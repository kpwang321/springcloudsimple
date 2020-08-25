package com.kpwang.mapper;

import com.kpwang.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kpwang
 * @create 2020-08-25 0:47
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{
}
