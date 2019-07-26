package com.xiaoping.exception;

import com.xiaoping.pojo.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Rs errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		logger.error("", e);
		if (e instanceof InvokeException) {
			InvokeException ex = (InvokeException)e;
			return Rs.err(ex.getErr(), ex.getMessage());
		}
		return Rs.errMsg("系统错误");
	}
}
