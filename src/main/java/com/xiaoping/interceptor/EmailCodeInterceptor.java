package com.xiaoping.interceptor;

import com.xiaoping.constant.Constans;
import com.xiaoping.exception.InvokeException;
import com.xiaoping.pojo.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 邮件验证码拦截器
 */
public class EmailCodeInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(EmailCodeInterceptor.class);

    /**
     * 执行于请求发生之前
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String code = request.getParameter("code");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        Object sessionCode = session.getAttribute(Constans.EMAIL_CODE_SESSION_KEY + email);
        if(null == sessionCode) {
            throw new InvokeException(Rs.ERROR_CODE_BAD_REQUEST, "请先发送验证码！");
        }
        logger.info("baseCode: " + code + ", code" + sessionCode.toString());
        if(!sessionCode.toString().equalsIgnoreCase(code)) {
            throw new InvokeException(Rs.ERROR_CODE_VALIDATION_NOT_PASS, "验证码错误！");
        }
        // 验证通过，清除验证码信息
        session.removeAttribute(Constans.EMAIL_CODE_SESSION_KEY + email);
        return true;
    }

    /**
     * 执行于请求发生之后，preHandle 方法中返回 true 才会执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 视图渲染完成后执行，同样需要 preHandle 方法中返回 true 才会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}
