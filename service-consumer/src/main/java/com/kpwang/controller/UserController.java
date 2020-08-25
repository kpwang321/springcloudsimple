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
    /*@Autowired
    private RestTemplate restTemplate;*/
    @Autowired
    private UserClient userClient;
    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        User user = userClient.queryById(id);
        return user;
    }
   /* @Autowired
    private DiscoveryClient discoveryClient;*/
/*    @GetMapping
    @HystrixCommand
    public User queryUserById(@RequestParam("id") Long id){
        //User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        //根据服务名称，获取服务实例，可能是集群，所以是实例集合
        //List<ServiceInstance> instances = this.discoveryClient.getInstances("service-provider");
        //ServiceInstance instance = instances.get(0);
        //String baseUrl="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        try {
            Thread.sleep(7000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String baseUrl="http://service-provider/user/"+id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);


        return user;
    }
    public User fallBackMethod(){
        User user=new User();
        user.setUsername("请求繁忙，请稍后再试");
        return user;
    }*/
}
