package org.bysj.pleural.facade;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.ChangePasswordRequestDTO;
import org.bysj.pleural.dto.user.UserDTO;
import org.bysj.pleural.enumeration.user.LockedStateEnum;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.JwtHelper;
import org.bysj.pleural.helper.MailHelper;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.service.CaptchaService;
import org.bysj.pleural.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
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

    @Autowired
    private MailHelper mailHelper;

    @Autowired
    private CaptchaService captchaService;

    /**
     * @param user
     * @return user
     * @Description: 用户注册
     * @date 2018/3/13 13:38
     * @author ljianf
     */
    public Response<?> regsiterUser(User user) {
        log.info("开始保存用户信息！");
        userSerivce.registeUser(user);
        log.info("调用邮件发送服务注册完成后自动登录");
        try {
            mailHelper.sendMail(user.getEmail(),user.getCode());
        } catch (Exception e) {
           log.error("邮件发送异常,原因:{}",e);
           throw new BusinessException(UserMessageConstant.USER_REGSITER_EMAIL_SEND_ERROR);
        }
        return Response.success();
    }


    /**
     * @Description: 用户登录
     * @date   2018/3/14 17:04
     * @param user
     * @return
     * @author ljianf
     */
    public Response<?> login(UserDTO user) {
        log.info("检查验证码是否正确");
        captchaService.checkCaptcha(user.getImgToken(),user.getVercode());
        return Response.success(userSerivce.login(user));
    }


    /**
     * @Description: 用户登出
     * @date   2018/3/14 17:10
     * @param
     * @return
     * @author ljianf
     */
    @Async
    public void logout(UserDTO user) {
        String key = USER_REDIS_PREFIX+user.getUserId()+":"+user.getUsername();
        if(redisHelp.containsKey(USER_REDIS_PREFIX+user.getUserId()+":"+user.getUsername())){
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
    public Response<?> changePassword(ChangePasswordRequestDTO request) {
        Integer isChanged = userSerivce.updatePassword(request);
        if(isChanged==1L){
            return Response.success();
        }
        return Response.error();
    }

}
