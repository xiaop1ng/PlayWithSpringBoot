package com.xiaoping.interceptor;

import com.xiaoping.constant.Constans;
import com.xiaoping.exception.InvokeException;
import com.xiaoping.pojo.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 图形验证码拦截器
 */
public class ImageCodeInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(ImageCodeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();

        Object sessionCode = session.getAttribute(Constans.IMAGE_CODE_SESSION_KEY);
        if(null == sessionCode) {
            throw new InvokeException(Rs.ERROR_CODE_BAD_REQUEST, "请先发送验证码！");
        }
        logger.info("baseCode: " + code + ", code" + sessionCode.toString());
        if(!sessionCode.toString().equalsIgnoreCase(code)) {
            throw new InvokeException(Rs.ERROR_CODE_VALIDATION_NOT_PASS, "验证码错误！");
        }
        // 验证通过，清除验证码信息
        session.removeAttribute(Constans.IMAGE_CODE_SESSION_KEY);
        return true;
    }
}
