package com.xiaoping.service;

import java.util.List;

import com.xiaoping.pojo.Stu;

public interface StuService {
	
	public void save(Stu user) throws Exception;

	public void update(Stu user);

	public void del(String userId);

	public Stu queryById(int userId);

	public List<Stu> gets(Stu user);

	public List<Stu> list(Stu user, Integer page, Integer pageSize);
	
}
