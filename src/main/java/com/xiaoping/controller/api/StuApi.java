package com.xiaoping.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoping.pojo.Rs;
import com.xiaoping.pojo.Stu;
import com.xiaoping.service.StuService;

@RestController
@RequestMapping("stu")
public class StuApi {

	@Autowired
	private StuService stuService;
	
	
	@RequestMapping("/del")
	public Rs deleteUser(String userId) {
		
		stuService.del(userId);
		
		return Rs.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public Rs queryUserById(int userId) {
		return Rs.ok(stuService.queryById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public Rs queryUserList() {
		
		Stu user = new Stu();
		user.setName("jack");
		
		List<Stu> userList = stuService.gets(user);
		
		return Rs.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public Rs queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		Stu user = new Stu();
		
		List<Stu> userList = stuService.list(user, page, pageSize);
		
		return Rs.ok(userList);
	}
	
}
