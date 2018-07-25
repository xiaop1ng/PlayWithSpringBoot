package com.xiaoping.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	String home() {
		return "Hello, SpringBoot!";
	}

}
