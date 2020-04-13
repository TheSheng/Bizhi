package com.bishe.java.controller;


import com.bishe.java.pojo.User;
import com.bishe.java.service.UserService;
import com.bishe.java.util.ResponseError;
import com.bishe.java.util.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2020-01-13
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(value = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){

        try {
            Boolean hasRegister = userService.hasRegister(user);
            if(hasRegister){
                return  ResponseError.create("注册失败，已被注册");
            }
            userService.save(user);
            return ResponseOk.create(user);
        }catch (Exception e){
            return  ResponseError.create("注册失败："+e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody User user){
        try {
            userService.updateById(user);
            return  ResponseOk.create("修改成功");
        }catch (Exception e){
            return  ResponseError.create("修改失败:"+e.getMessage());
        }
    }
    @GetMapping("/hasRegister")
    public  ResponseEntity hasRegister(@RequestParam("phone")String phone){
        try {
            User user=new User();
            user.setUsername(phone);
            Boolean hasRegister = userService.hasRegister(user);
            if(hasRegister){
                return  ResponseOk.create("");
            }
            return  ResponseError.create("该手机尚未被注册，请先注册");

        }catch (Exception e){
            return  ResponseError.create(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        try {
            Boolean login = userService.login(user);
            if(login){
                User byUserNameAndPass = userService.getByUserNameAndPass(user);
                return ResponseOk.create(byUserNameAndPass);
            }
            return  ResponseError.create("登录失败，请检查账号密码");
        }catch (Exception e){
            return  ResponseError.create("登录失败："+e.getMessage());
        }
    }
    @PostMapping("/getByPhone")
    public ResponseEntity getByPhone(@RequestBody User user){
        try {

            return ResponseOk.create(userService.getByPhone(user));
        }catch (Exception e){
            return  ResponseError.create("登录失败："+e.getMessage());
        }
    }


}

