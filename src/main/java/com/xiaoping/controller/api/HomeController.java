package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.exception.InvokeException;
import com.xiaoping.pojo.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController extends BaseBizController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "Hello, SpringBoot!";
	}

//	@GetMapping("/starter")
//	String starter(){return helloService.sayHello();}

	/**
	 * test AuthorizationInterceptor
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	Rs auth() {
		logger.info("[入参]" + getParamMap().toString());
		logger.info("[当前用户]" + attr("_username").toString());
		return Rs.ok("授权通过!");
	}

	@GetMapping("/exception")
	Rs exception() {
		throw new InvokeException("丑拒！");
	}

	@GetMapping("/try")
	Rs testtry() {
		// 这里捕获到的异常就不会再向外抛了
		try {
			throw new InvokeException("丑拒！");
		}catch (Exception e) {

		}
		return Rs.ok();
	}

}
