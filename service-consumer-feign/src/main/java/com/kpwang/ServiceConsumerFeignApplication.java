package com.kpwang;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kpwang
 * @create 2020-08-25 14:00
 */
@SpringCloudApplication//这个注解包含了以上三个注解
@EnableFeignClients//开启feign客户端
public class ServiceConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFeignApplication.class);
    }
}
