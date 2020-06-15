package com.bobo.service;

import com.bobo.beans.UserAndPhoneCode;
import com.bobo.utils.ServerResponse;
import org.apache.catalina.Server;

import javax.servlet.http.HttpSession;

public interface IUserService {
    /**
     * 发送并获取手机号验证码
     *
     */
    ServerResponse sendPhoneCode(String username,int status, HttpSession httpSession);
    /**
     * 用账号（手机号）和密码登陆
     */
    ServerResponse loginByAccount(String username, String password);
    /**
     * 用手机验证码登陆
     */
    ServerResponse loginByPhoneCode(String username,String phonecode,HttpSession httpSession);
    /**
     * 注册
     */
    ServerResponse registeredLogic(UserAndPhoneCode userAndPhoneCode);
}
