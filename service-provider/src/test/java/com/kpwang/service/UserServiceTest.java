package com.kpwang.service;

import com.kpwang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-08-25 1:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void addUser() {
        User user=new User();
        user.setUsername("liqin");
        user.setPassword("abc123");
        user.setName("李沁");
        user.setAge(29);
        user.setSex(1);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userService.addUser(user);
    }
}