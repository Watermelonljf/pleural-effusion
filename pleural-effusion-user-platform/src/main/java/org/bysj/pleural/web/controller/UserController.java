package org.bysj.pleural.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.UserDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.UserFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response<?> login(@RequestBody  UserDTO user){
        if(StringUtils.isBlank(user.getUsername())){
            throw new BusinessException(UserMessageConstant.USER_USERNAME_EMPTY);
        }
        if(StringUtils.isBlank(user.getPassword())){
            throw new BusinessException(UserMessageConstant.USER_PASSWORD_EMPTY);
        }
        User userCmp = new User();
        BeanUtils.copyProperties(user,userCmp,User.class);
        return userFacade.login(userCmp);
    }

    @RequestMapping(value = "/logout")
    @Async
    public Response<?> logout(UserDTO user){
        final User userCmp = new User();
        BeanUtils.copyProperties(user,userCmp,User.class);
        userFacade.logout(userCmp);
        return Response.success();
    }
}
