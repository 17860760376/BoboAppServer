package com.bobo.service;

import com.bobo.utils.ServerResponse;

public interface IUserService {
    /**
     * 用账号（手机号）和密码登陆
     */
    public ServerResponse loginByAccount(String username,String password);
}
