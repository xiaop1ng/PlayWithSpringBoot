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

/**
 * JSONWEBTOKEN 验权拦截器
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorization = request.getHeader(Constans.HEADER_AUTHORIZATION);
        if(StringHelper.isEmpty(authorization)) {
            throw new InvokeException(Rs.ERROR_CODE_UNAUTHORIZED, "no authorization.");
        }
        String token = authorization.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(Constans.JWT_SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(Constans.JWT_ISSUER)
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        String username = jwt.getClaim("username").asString();
        String id = jwt.getClaim("id").asString();
        request.setAttribute("_username", username);
        request.setAttribute("_id", id);
        return true;
    }
}
