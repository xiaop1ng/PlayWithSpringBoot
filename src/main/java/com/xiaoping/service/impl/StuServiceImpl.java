package com.xiaoping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import com.xiaoping.mapper.StuMapper;
import com.xiaoping.pojo.Stu;
import com.xiaoping.service.StuService;

import tk.mybatis.mapper.entity.Example;

@Service
public class StuServiceImpl implements StuService{

	@Autowired
	private StuMapper stuMapper;
	@Override
	public void save(Stu user) throws Exception {
		stuMapper.insert(user);
	}

	@Override
	public void update(Stu user) {
		stuMapper.updateByPrimaryKey(user);
	}

	@Override
	public void del(String userId) {
		stuMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public Stu queryById(int userId) {
		return stuMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<Stu> gets(Stu user) {
		Example example = new Example(Stu.class);
		List<Stu> userList = stuMapper.selectByExample(example);
		
		return userList;
	}

	@Override
	public List<Stu> list(Stu user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		
		Example example = new Example(Stu.class);
		Example.Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmpty(user.getName())) {
			criteria.andLike("name_", "%" + user.getName() + "%");
		}
		example.orderBy("id").desc();
		List<Stu> userList = stuMapper.selectByExample(example);
		
		return userList;
	}

}
