package com.xiaoping.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "Hello, SpringBoot!";
	}

//	@GetMapping("/starter")
//	String starter(){return helloService.sayHello();}

}
