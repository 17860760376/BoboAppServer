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
    ServerResponse loginByAccount(String username, String password);
    /**
     * 用手机验证码登陆
     */
    ServerResponse loginByPhoneCode(HttpServletRequest request,String username,String phonecode);
    /**
     * 注册
     */
    ServerResponse registeredLogic(HttpServletRequest request,String username,String phonecode,String password,String _password);
}
