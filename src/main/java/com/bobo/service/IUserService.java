package com.bobo.service;

import com.bobo.utils.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    /**
     * 发送并获取手机号验证码
     *
     */
    ServerResponse sendPhoneCode(HttpServletRequest request,String username, int status);
    /**
     * 用账号（手机号）和密码登陆
     */
    ServerResponse loginByAccount(HttpServletRequest request,String username, String password);
    /**
     * 用手机验证码登陆
     */
    ServerResponse loginByPhoneCode(HttpServletRequest request,String username,String phonecode);
    /**
     * 注册
     */
    ServerResponse registeredLogic(HttpServletRequest request,String username,String phonecode,String password,String _password);
    /**
     * 根据旧密码去修改密码
     */
    ServerResponse updatePswByPsw(String username,String oldPassword,String newPassword);

    /**
     * 通过手机验证码修改密码，进行身份验证接口
     */
    ServerResponse updatePswByPhoneCode(HttpServletRequest request,String username,String phonecode);

    /**
     * 通过手机验证码修改密码，身份验证成功后传入要修改的密码进行修改
     * @param username
     * @param password
     * @return
     */
    ServerResponse updatePswByPhoneCodeFinal(String username,String password);

}

