package com.bobo.service.impl;

import com.bobo.beans.UserAndPhoneCode;
import com.bobo.common.ResponseCode;
import com.bobo.dao.UserMapper;
import com.bobo.pojo.User;
import com.bobo.service.IUserService;
import com.bobo.utils.CreatePhoneCode;
import com.bobo.utils.SendPhoneCode;
import com.bobo.utils.ServerResponse;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;


    /**
     * 用账号和密码登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 用账号和验证码进行登录
     * @param username
     * @param phonecode
     * @return
     */
    @Override
    public ServerResponse loginByPhoneCode(String username, String phonecode,HttpSession httpSession) {
        //step1:判断手机号和验证码非空
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(phonecode==null||phonecode.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_NOT_EMPTY.getCode(),ResponseCode.PHONECODE_NOT_EMPTY.getMsg());
        //step2:判断用户是否存在
        int count = userMapper.findByUsername(username);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        //step3:判断用户手机号和验证码是否相符\
        String _phonecode = (String)httpSession.getAttribute(username);
        httpSession.removeAttribute(username);
        if(_phonecode!=phonecode)
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_ERROR.getCode(),ResponseCode.PHONECODE_ERROR.getMsg());
        //step4:返回结果
            return ServerResponse.createServerResponseBySucess();
    }

    /**
     * 发送验证码，根据status来进行不同的处理
     * @param username
     * @param status
     * @return
     */
    @Override
    public ServerResponse sendPhoneCode(String username, int status,HttpSession httpSession) {
        //step1:手机号的非空校验
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        //step2:结合status来判断手机号是否存在
        int count=userMapper.findByUsername(username);
        if(status==0){//用于登陆和修改密码
            if(count==0)
                return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());

        }
        else if(status==1){//用于注册
            if(count!=0)
                return ServerResponse.createServerResponseByFail(ResponseCode.USERANME_EXISTS.getCode(),ResponseCode.USERANME_EXISTS.getMsg());
        }
        //step3:给用户发送验证码并保存
        String phonecode = CreatePhoneCode.createRandom(true,6);
        HttpResponse httpResponse = SendPhoneCode.sendPhoneCode(username,phonecode);
        //step4:将手机号和验证码保存在session中,注意这里有一个时间，要设置一下session中的内容保存时间
        httpSession.setAttribute(username,phonecode);
        return ServerResponse.createServerResponseBySucess();
    }

    /**
     *注册
     * @param userAndPhoneCode
     * @return
     */
    @Override
    public ServerResponse registeredLogic(UserAndPhoneCode userAndPhoneCode) {
        //写注册逻辑
        //...
        return null;
    }

}
