package com.xiaoping.controller.api;

import com.xiaoping.pojo.Rs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "Hello, SpringBoot!";
	}

//	@GetMapping("/starter")
//	String starter(){return helloService.sayHello();}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	Rs auth() {
		return Rs.ok("授权通过!");
	}

}
