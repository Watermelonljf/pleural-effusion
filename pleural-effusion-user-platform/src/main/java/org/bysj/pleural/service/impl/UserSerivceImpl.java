package org.bysj.pleural.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.user.ChangePasswordRequestDTO;
import org.bysj.pleural.dto.user.ClientUserInfoDTO;
import org.bysj.pleural.enumeration.user.LockedStateEnum;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.JwtHelper;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.mapper.UserMapper;
import org.bysj.pleural.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * <pre>类名: UserSerivceImpl</pre>
 * <pre>描述: 用户业务实现类</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/13  13:51</pre>
 * <pre>作者: ljianf</pre>
 */
@Service
@Slf4j
public class UserSerivceImpl implements UserService {

    @Value( "${redis.user.key.expire}")
    private String EXPIRATIONTIME;

    private static final String USER_REDIS_PREFIX="user:";

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private RedisHelp redisHelp;

    @Autowired
    private UserMapper userMapper;


    @Override
    public User registeUser(User user) {
        String salt = UUID.randomUUID().toString();
        //设置加密后的密码
        user.setPassword(DigestUtils.md5Hex(user.getPassword() + salt));
        user.setSalt(salt);
        userMapper.saveUser(user);
        return user;
    }

    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public Integer updatePassword(ChangePasswordRequestDTO request) {
        log.info("修改密码：查询当前用户【{}】信息。",request.getUsername());
        User loginUser = this.findUserByUsername(request.getUsername());
        //旧密码输入错误
        log.info("修改密码：校验旧密码");
        if (!DigestUtils.md5Hex(request.getOldPassword() + loginUser.getSalt()).equals(loginUser.getPassword())) {
            log.warn("修改密码：校验旧密码不通过");
            throw new BusinessException(UserMessageConstant.USER_CHANGE_PASSWORD_OLD_PASSWORD_ERROR_INFO);
        }
        request.setNewPassword(DigestUtils.md5Hex(request.getNewPassword()+loginUser.getSalt()));
        //清楚redis信息
        String key = USER_REDIS_PREFIX+loginUser.getId()+":"+loginUser.getUsername();
        if(redisHelp.containsKey(key)){
            redisHelp.remove(key);
        }
        return userMapper.changePasswordByUsername(request.getUsername(),request.getNewPassword());
    }


    @Override
    public List<User> listUserPage(){
        return null;
    }

    @Override
    public ClientUserInfoDTO login(User user) {
        User loginUser = userMapper.findUserByUsername(user.getUsername());
        log.info("检查登录信息开始");
        judgeUserInfo(loginUser,user);
        log.info("检查登录信息结束");
        //登录成功,签发token
        log.info("开始签发Token");
        String token = jwtHelper.createAuthenticationToken(user);
        //操作redis
        redisHelp.cacheValue(USER_REDIS_PREFIX+user.getId()+":"+user.getUsername(),user,Long.parseLong(EXPIRATIONTIME));
        ClientUserInfoDTO userInfo = new ClientUserInfoDTO();
        userInfo.setUsername(user.getUsername());
        userInfo.setUserId(loginUser.getId());
        userInfo.setToken(token);
        return userInfo;
    }

    private Boolean judgeUserInfo(User loginUser,User user){
        //用户不存在
        if (Objects.isNull(loginUser)) {
            throw new BusinessException(UserMessageConstant.USER_NOT_EXIST_INFO);
        }
        //首先判断用户是否是锁定用户
        if (LockedStateEnum.USER_LOCKED.getCode() == loginUser.getLocked()) {
            throw new BusinessException(UserMessageConstant.USER_LOCKED_INFO);
        }
        //用户名或密码错误
        if (!DigestUtils.md5Hex(user.getPassword() + loginUser.getSalt()).equals(loginUser.getPassword())) {
            throw new BusinessException(UserMessageConstant.USER_PASSWORD_OR_USERNAME_ERROR_INFO);
        }
        return true;
    }
}
