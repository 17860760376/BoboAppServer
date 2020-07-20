package com.bobo.controller;
import com.bobo.service.IUserService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *与用户相关的一定的接口
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    /**
     *TODO 根据账号密码进行登录
     */
    @Autowired
    IUserService userService;
    @GetMapping(value = "account/login.do")
    public ServerResponse loginByAccount(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password){
        ServerResponse serverResponse=userService.loginByAccount(request,username,password);
        return serverResponse;
    }
    /**
     * TODO 发送验证码
     */
    @GetMapping(value = "send/phonecode.do")
    public ServerResponse sendPhoneCode(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("status") int status){
        ServerResponse serverResponse = userService.sendPhoneCode(request,username,status);
        return serverResponse;
    }
    /**
     * TODO 用手机号和验证码进行登录
     */
    @GetMapping(value = "phonecode/login.do")
    public ServerResponse loginByPhoneCode(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("phonecode") String phonecode){
        ServerResponse serverResponse = userService.loginByPhoneCode(request,username,phonecode);
        return serverResponse;
    }


    /**
     * 注册
     */
    @PostMapping(value = "register.do")
    public ServerResponse register(HttpServletRequest request,String username,String phonecode,String password,String _password){
        ServerResponse serverResponse = userService.registeredLogic(request,username,phonecode,password,_password);
        return serverResponse;
    }

    /**
     * 根据旧密码修改新密码
     */
    @GetMapping(value = "update/byoldpsw.do")
    public ServerResponse updatePswByOldpsw(String username,String oldPassword,String newPassword){
        ServerResponse serverResponse = userService.updatePswByPsw(username,oldPassword,newPassword);
        return serverResponse;
    }


    /**
     * 根据手机验证码修改密码，身份验证接口
     * @param request
     * @param username
     * @param phonecode
     * @return
     */
    @GetMapping(value = "update/byphonecode.do")
    public ServerResponse updatePswByPhoneCode(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("phonecode") String phonecode){
        ServerResponse serverResponse = userService.updatePswByPhoneCode(request,username,phonecode);
        return  serverResponse;
    }

    /**
     * 根据手机验证码修改密码，修改密码接口
     * @param username
     * @param password
     * @return
     */
    @GetMapping(value = "update/byphonecodefinal.do")
    public ServerResponse updatePswByPhoneCodeFinal(String username,String password){
        ServerResponse serverResponse = userService.updatePswByPhoneCodeFinal(username,password);
        return serverResponse;
    }
}
