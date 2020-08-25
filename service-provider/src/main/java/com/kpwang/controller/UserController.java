package com.kpwang.controller;

import com.kpwang.pojo.User;
import com.kpwang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpwang
 * @create 2020-08-25 0:49
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        /*try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.queryById(id);
    }
}
