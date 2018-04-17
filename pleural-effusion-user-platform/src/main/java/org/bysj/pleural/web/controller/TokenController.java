package org.bysj.pleural.web.controller;

import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.helper.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: TokenControllrt
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/16
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/check")
    public Response<?> checkToken(@RequestParam("accessToken") String token){
        return Response.success(jwtHelper.checktoken(token));
    }
}
