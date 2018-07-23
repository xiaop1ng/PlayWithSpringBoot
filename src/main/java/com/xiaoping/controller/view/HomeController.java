package com.xiaoping.controller.view;

import com.xiaoping.pojo.Rs;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	String home(ModelMap map) {
		return "msg from home";
	}
	
	@RequestMapping("/index")
	Rs index(ModelMap map) {
		return Rs.ok("HelloWorld!");
	}
	
	@RequestMapping("/err")
	String err() {
		int a =1/0; // ERROR 测试 Exception Handler
		return null;
	}
}
