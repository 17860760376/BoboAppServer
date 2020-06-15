package com.bobo.controller;


import com.alibaba.fastjson.JSONObject;
import com.bobo.beans.UserAndPhoneCode;
import com.bobo.pojo.User;
import com.bobo.service.IUserService;
import com.bobo.utils.ServerResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 *与用户相关的一定的接口
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    /**
     * 根据账号密码进行登录
     */
    @Autowired
    IUserService userService;
    @GetMapping(value = "account/login.do")
    public ServerResponse loginByAccount(@RequestParam("username") String username,@RequestParam("password") String password){
        ServerResponse serverResponse=userService.loginByAccount(username,password);
        return serverResponse;
    }
    /**
     * 发送验证码
     */
    @GetMapping(value = "send/phonecode.do")
    public ServerResponse sendPhoneCode(@RequestParam("username") String username,@RequestParam("status") int status,HttpSession httpSession){
        ServerResponse serverResponse = userService.sendPhoneCode(username,status,httpSession);
        return serverResponse;
    }
    /**
     * 用手机号和验证码进行登录
     *
     */
    @GetMapping(value = "phonecode/login.do")
    public ServerResponse loginByPhoneCode(@RequestParam("username")String username,@RequestParam("phonecode") String phonecode,HttpSession httpSession){
        ServerResponse serverResponse = userService.loginByPhoneCode(username,phonecode,httpSession);
        return serverResponse;
    }
    /**
     * 注册
     */
    @PostMapping(value = "register.do")
    public ServerResponse register(@RequestBody UserAndPhoneCode userAndPhoneCode){
        ServerResponse serverResponse = userService.registeredLogic(userAndPhoneCode);
        return serverResponse;
    }
}
