package com.kpwang.service;

import com.kpwang.mapper.UserMapper;
import com.kpwang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kpwang
 * @create 2020-08-25 0:48
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    public void addUser(User user){
        userMapper.insertSelective(user);
        System.out.println(user.getId());
    }
}
