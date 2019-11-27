package com.xiaoping.test;

import com.xiaoping.entity.TUser;
import com.xiaoping.mapper.UserMapper;
import org.junit.After;
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
        userList.forEach(System.out::println);
    }

    @Test
    public void addTUser() {
        System.out.println("注册用户开始");
        for (int i = 0; i < 30; i++) {
            TUser user = new TUser();
            user.setName("小月num" + i);
            user.setAge(20 + i);
            user.setEmail("xiaojia" + i + "@thinkive.com");
            int ret = userMapper.insert(user);
            System.out.println("[ret]" + ret);
        }

    }

    @Test
    public void updateTUser() {
        TUser user = new TUser();
        user.setId(1199575052459196417L);
        user.setName("小月月");
        int ret = userMapper.updateById(user);
        System.out.println("[ret]" + ret);
    }


    @Test
    public void delTUser() {

    }

    @Test
    public void getTUserPage() {

    }


    @After
    public void after() {
        System.out.println("after invoke!");
    }
}
