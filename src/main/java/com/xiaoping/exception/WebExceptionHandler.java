package com.xiaoping.exception;

import com.xiaoping.pojo.Rs;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Rs errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		return Rs.errMsg("系统错误");
	}
}
