package org.bysj.pleural.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Watermelon_R on 2017/6/29.
 *
 * http请求切面处理类
 *
 */
@Aspect
@Component
@Order(1)
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * 重用切点表达式
     */
    @Pointcut("execution(public * org.bysj.pleural.web.*.*(..))") //web包下所有方法
    public void log(){

    }

    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("classMethod={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //方法参数
        logger.info("args={}",joinPoint.getArgs());

    }

 /*   @After("log()")
    public void doAfter(){
        logger.info("after");
        //获取response
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //核心设置
        response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域
    }*/

    /*@AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }*/

}
