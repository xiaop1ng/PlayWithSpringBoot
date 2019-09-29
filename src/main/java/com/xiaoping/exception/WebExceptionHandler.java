package com.xiaoping.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.xiaoping.constant.Constans;
import com.xiaoping.pojo.Rs;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常捕获处理类
 */
@ControllerAdvice
public class WebExceptionHandler {

	private Logger logger = Logger.getLogger(WebExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Rs errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		logger.error("", e);
		if (e instanceof InvokeException) {
			InvokeException ex = (InvokeException)e;
			return Rs.err(ex.getErr(), ex.getMessage());
		} else if (e instanceof TokenExpiredException) {
			res.setHeader(Constans.HEADER_AUTHORIZATION, null);
			return Rs.err(Rs.ERROR_CODE_AUTHORIZED_TIMEOUT, "会话已过期，请重新登录！");
		} else if (e instanceof JWTVerificationException) {
			return Rs.err(Rs.ERROR_CODE_UNAUTHORIZED, "验证授权出错！");
		}
		return Rs.errMsg("系统错误");
	}
}
