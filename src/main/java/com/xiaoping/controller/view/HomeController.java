package com.xiaoping.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	String home(ModelMap map) {
		map.put("name", "SpringBootFreeMarker");
		return "/pages/index";
	}
	
	@RequestMapping("/index")
	String index(ModelMap map) {
		map.put("name", "SpringBootFreeMarker");
		return "/pages/index";
	}
	
	@RequestMapping("/err")
	String err() {
		int a =1/0; // ERROR 测试 Exception Handler
		return null;
	}
}
