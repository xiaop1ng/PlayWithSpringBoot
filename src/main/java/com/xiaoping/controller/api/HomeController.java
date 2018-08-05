package com.xiaoping.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/")
	String home() {
		return "Hello, SpringBoot!";
	}

//	@GetMapping("/starter")
//	String starter(){return helloService.sayHello();}

}
