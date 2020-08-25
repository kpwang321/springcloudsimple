package com.kpwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author kpwang
 * @create 2020-08-25 15:05
 */
@SpringBootApplication
@EnableEurekaServer//声明当前springboot应用是一个eureka服务中心
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class);
    }
}
