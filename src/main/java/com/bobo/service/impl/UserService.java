package com.bobo.service.impl;

import com.bobo.common.ResponseCode;
import com.bobo.dao.UserMapper;
import com.bobo.pojo.User;
import com.bobo.service.IUserService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public ServerResponse loginByAccount(String username, String password) {
        //step1:用户名和密码的非空判断
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(password==null||password.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        //step2:查看用户名是否存在
        int count = userMapper.findByUsername(username);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());

        //step3:根据用户名和密码查询
        User user = userMapper.findByUsernameAndPassword(username,password);
        if(user==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getMsg());

        //step4:返回结果

        return  ServerResponse.createServerResponseBySucess(user);

    }
}
