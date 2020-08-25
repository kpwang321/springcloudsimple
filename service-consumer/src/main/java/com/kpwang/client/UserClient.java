package com.kpwang.client;

import com.kpwang.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kpwang
 * @create 2020-08-25 17:48
 */
@FeignClient(value = "service-provider",fallback = UserClientFallback.class)//标注该类是一个feign接口
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
