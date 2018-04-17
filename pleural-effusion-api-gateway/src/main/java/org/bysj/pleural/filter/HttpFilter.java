package org.bysj.pleural.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.helper.RedisHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * className: FttpFilter
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/16
 */
@Component
@Slf4j
public class HttpFilter extends ZuulFilter{

    static final long EXPIRATIONTIME = 86400000;     // 一天
    static final String SECRET = "Wa@ter#Melon";            // JWT秘钥
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key


    @Autowired
    private RedisHelp redisHelp;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String url=request.getRequestURL().toString();
        if(url.endsWith("/captcha/get")||url.endsWith("/user/login")){
            return null;
        }
        //获取传来的参数accessToken
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("access token is empty");
            //过滤该请求，不往下级服务去转发请求，到此结束
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"accessToken为空!\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            return null;
        }else{
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(accessToken.toString()).getBody();
           if(new Date().after(claims.getExpiration())){//判断是否过期
               ctx.setSendZuulResponse(false);
               ctx.setResponseStatusCode(401);
               ctx.setResponseBody(JSON.toJSONString(Response.expired()));
           }
        }
        //如果有token，则进行路由转发
        log.info("access token ok");
        //这里return的值没有意义，zuul框架没有使用该返回值
        return null;
    }
}
