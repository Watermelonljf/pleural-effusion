package org.bysj.pleural.helper;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bysj.pleural.bean.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * <pre>类名: JwtHelper</pre>
 * <pre>描述: JWT帮助类</pre>
 * <pre>日期: 2018/3/14  14:52</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
public class JwtHelper {

    static final long EXPIRATIONTIME = 86400000;     // 一天
    static final String SECRET = "Wa@ter#Melon";            // JWT秘钥
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key

    public String createAuthenticationToken(User user){
        Map<String, Object> claims = Maps.newHashMap();
        claims.put("username",user.getUsername());
        claims.put("userId",user.getId());
        String token = Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }
}
