package org.bysj.pleural.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.UserDTO;
import org.bysj.pleural.enumeration.common.ResponseTypeEnum;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.UserFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>类名: UserController</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/13  16:16</pre>
 * <pre>作者: ljianf</pre>
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;


    @PostMapping(value = "/login")
    public Response<?> login(UserDTO user){
        if(StringUtils.isBlank(user.getUsername())){
            throw new BusinessException(UserMessageConstant.USER_USERNAME_EMPTY);
        }
        if(StringUtils.isBlank(user.getPassword())){
            throw new BusinessException(UserMessageConstant.USER_PASSWORD_EMPTY);
        }
        return userFacade.login(user);
    }

    @RequestMapping(value = "/logout")
    public Response<?> logout(UserDTO user){
        final User userCmp = new User();
        userFacade.logout(user);
        return new Response(ResponseTypeEnum.SUCCESS,null,null,null);
    }


   @PostMapping(value = "/register")
    public Response<?> register(User user){
       return userFacade.regsiterUser(user);
    }
}
