package com.bobo.controller;


import com.bobo.pojo.User;
import com.bobo.service.IUserService;
import com.bobo.utils.ServerResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 *与用户相关的一定的接口
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;
    @GetMapping(value = "account/login.do")
    public ServerResponse loginByAccount(@RequestParam("username") String username,@RequestParam("password") String password){
        ServerResponse serverResponse=userService.loginByAccount(username,password);
        return serverResponse;
    }

}
