package com.xiaoping.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xiaoping.constant.Constans;
import com.xiaoping.exception.InvokeException;
import com.xiaoping.pojo.Rs;
import com.xiaoping.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class AuthorizationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);


    private String secret = "YebNZYFXAL1qUjX8516Mi";

    private String issuer = "auth0";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorization = request.getHeader(Constans.HEADER_AUTHORIZATION);
        if(StringHelper.isEmpty(authorization)) {
            throw new InvokeException(Rs.ERROR_CODE_UNAUTHORIZED, "no authorization.");
        }
        String token = authorization.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        Date expiresAt = jwt.getExpiresAt();
        if(expiresAt.before(new Date())) {
            // 已过期
            response.setHeader(Constans.HEADER_AUTHORIZATION, null);
            throw new InvokeException(Rs.ERROR_CODE_AUTHORIZED_TIMEOUT, "会话已过期，请重新登录！");
        }

        String username = jwt.getClaim("username").toString();
        String id = jwt.getClaim("id").toString();
        request.setAttribute("_username", username);
        request.setAttribute("_id", id);
        return true;
    }
}
