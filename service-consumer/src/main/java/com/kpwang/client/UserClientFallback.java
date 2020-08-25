package com.kpwang.client;

import com.kpwang.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author kpwang
 * @create 2020-08-25 18:02
 */
@Component
public class UserClientFallback implements UserClient{

    @Override
    public User queryById(Long id) {
        User user=new User();
        user.setUsername("服务器繁忙，请稍后再试........");
        return user;
    }
}
