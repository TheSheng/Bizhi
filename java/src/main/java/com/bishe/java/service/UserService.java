package com.bishe.java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.java.mapper.UserMapper;
import com.bishe.java.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 席思诚123
 * @since 2020-01-13
 */
public interface UserService extends IService<User> {
   Boolean login(User user);
   Boolean hasRegister(User user);
   User getByUserNameAndPass(User ser);
    User getByPhone(User ser);


}
