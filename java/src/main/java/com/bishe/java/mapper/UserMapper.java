package com.bishe.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.java.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
     int login(@Param("user") User user);
     int hasRegister(@Param("user") User user);
     User getByUserName(@Param("user") User user);
    User getByPhone(@Param("user") User user);


}
