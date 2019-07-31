package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.pojo.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseBizController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "Hello, SpringBoot!";
	}

//	@GetMapping("/starter")
//	String starter(){return helloService.sayHello();}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	Rs auth() {
		logger.info("[入参]" + getParamMap().toString());
		logger.info("[当前用户]" + attr("_username").toString());
		return Rs.ok("授权通过!");
	}

}
