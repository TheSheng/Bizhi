package com.bishe.java.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.java.pojo.User;
import com.bishe.java.mapper.UserMapper;
import com.bishe.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 席思诚123
 * @since 2020-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    public Boolean login(User user){
        return userMapper.login(user)>0?true:false;
    }

    @Override
    public Boolean hasRegister(User user) {
        return userMapper.hasRegister(user)>0?true:false;

    }

    @Override
    public User getByUserNameAndPass(User user) {

        return userMapper.getByUserName(user);
    }

    @Override
    public User getByPhone(User ser) {
        return userMapper.getByPhone(ser);
    }
}
