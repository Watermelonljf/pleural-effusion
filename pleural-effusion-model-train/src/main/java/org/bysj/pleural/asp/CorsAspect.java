package org.bysj.pleural.asp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Watermelon_R on 2017/9/20.
 */

public class CorsAspect {

    /**
     * 重用切点表达式
     */
   /* @Pointcut("execution(public * org.nan9981.web.*.*(..)) && !execution(public * org.nan9981.web.UserController.*(..))") //web包下所有方法
    public void log(){

    }

    @After("log()")
    public Object testAop() throws Throwable {
        //获取response
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //核心设置
        response.setHeader("Access-Control-Allow-Origin", "*");
    }*/
}
