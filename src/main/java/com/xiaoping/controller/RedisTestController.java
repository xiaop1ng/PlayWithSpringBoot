package com.xiaoping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoping.pojo.Rs;
import com.xiaoping.pojo.Stu;
import com.xiaoping.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisTestController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public Rs test() {
		
		strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");
		
		return Rs.ok();
	}
	
	@RequestMapping("/getJsonList")
	public String getJsonList() throws JsonProcessingException {
		
		Stu user = new Stu();
		user.setName("慕课网");

		Stu u1 = new Stu();
		u1.setName("imooc");

		
		Stu u2 = new Stu();
		u2.setName("hello imooc");

		
		List<Stu> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		ObjectMapper mapper = new ObjectMapper();
		
		redis.set("json:info:userlist", mapper.writeValueAsString(userList), 2000);
		
		String userListJson = redis.get("json:info:userlist");
		
		return userListJson;
	}
	
}
