package com.kpwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kpwang
 * @create 2020-08-25 0:40
 */
@SpringBootApplication
@EnableDiscoveryClient//开启Eureka的客户端功能
public class ServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class);
    }
}
