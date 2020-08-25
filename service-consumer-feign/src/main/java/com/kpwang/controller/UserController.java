package com.kpwang.controller;

import com.kpwang.client.UserClient;
import com.kpwang.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-08-25 14:03
 */
@RestController
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallBackMethod")
public class UserController {
    @Autowired
    private UserClient userClient;
    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        User user = userClient.queryById(id);
        return user;
    }
}
