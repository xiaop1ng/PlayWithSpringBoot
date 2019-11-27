package com.xiaoping.test;

import com.xiaoping.entity.TUser;
import com.xiaoping.mapper.UserMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
// 指定启动类
@SpringBootTest(classes = AppTest.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void before() {
        System.out.println("before invoke!");
    }

    @Test
    public void testSelect() {
        System.out.println("test invoke!");

        List<TUser> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @After
    public void after() {
        System.out.println("after invoke!");
    }
}
