package com.xiaoping.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ex", e.getMessage());
		mav.setViewName("error");
		return mav;
		
	}
}
