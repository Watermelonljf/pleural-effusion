package org.bysj.pleural.facade;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.enumeration.user.LockedStateEnum;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.JwtHelper;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * <pre>类名: UserFacade</pre>
 * <pre>描述: 用户Facade</pre>
 * <pre>日期: 2018/3/14  10:20</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
@Slf4j
public class UserFacade {

    private static final String USER_REDIS_PREFIX="user:";

    private static final Long EXPIRATIONTIME = 86400l;

    @Autowired
    private RedisHelp redisHelp;

    @Autowired
    private UserService userSerivce;

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * @param user
     * @return user
     * @Description: 用户注册
     * @date 2018/3/13 13:38
     * @author ljianf
     */
    public User regsiterUser(User user) {
        String salt = UUID.randomUUID().toString();
        //设置加密后的密码
        user.setPassword(DigestUtils.md5Hex(user.getPassword() + salt));
        user.setSalt(salt);
        userSerivce.saveUserInfo(user);
        return user;
    }


    /**
     * @Description: 用户登录
     * @date   2018/3/14 17:04
     * @param user
     * @return
     * @author ljianf
     */
    public String login(User user) {
        User loginUser = userSerivce.findUserByUsername(user.getUsername());
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
        //登录成功,签发token
        String token = jwtHelper.createAuthenticationToken(user);

        //操作redis
        redisHelp.cacheValue(USER_REDIS_PREFIX+loginUser.getId()+":"+loginUser.getUsername(),user,EXPIRATIONTIME);

        return token;

    }


    /**
     * @Description: 用户登出
     * @date   2018/3/14 17:10
     * @param
     * @return
     * @author ljianf
     */
    public void logout(User user) {
        String key = USER_REDIS_PREFIX+user.getId()+":"+user.getUsername();
        if(redisHelp.containsKey(USER_REDIS_PREFIX+user.getId()+":"+user.getUsername())){
            redisHelp.remove(key);
        }
    }

    /**
     * @param user
     * @return user
     * @Description: 修改密码
     * @date 2018/3/13 13:51
     * @author ljianf
     */
    public User changePassword(User user) {

        return null;
    }

}
