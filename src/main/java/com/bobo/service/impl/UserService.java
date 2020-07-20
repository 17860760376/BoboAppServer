package com.bobo.service.impl;

import com.bobo.common.Const;
import com.bobo.common.ResponseCode;
import com.bobo.dao.UserInformationMapper;
import com.bobo.dao.UserMapper;
import com.bobo.pojo.User;
import com.bobo.pojo.UserInformation;
import com.bobo.service.IUserService;
import com.bobo.utils.*;
import io.swagger.models.auth.In;
import org.apache.http.HttpResponse;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInformationMapper userInformationMapper;

    /**
     * 用账号和密码登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ServerResponse loginByAccount(HttpServletRequest request,String username, String password) {
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
        User user = userMapper.findByUsernameAndPassword(username,MD5utils.getPwd(password));
        if(user==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getMsg());
        //step4:返回结果
        User user1 = userMapper.selectUserByUsername(username);
        request.getSession().setAttribute(user1.getBoboNumber(),user1);
        return  ServerResponse.createServerResponseBySucess(user);
    }




    /**
     * 用账号和验证码进行登录
     * @param username
     * @param phonecode
     * @return
     */
    @Override
    public ServerResponse loginByPhoneCode(HttpServletRequest request,String username, String phonecode) {
        //step1:判断手机号和验证码非空
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(phonecode==null||phonecode.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_NOT_EMPTY.getCode(),ResponseCode.PHONECODE_NOT_EMPTY.getMsg());



        //step2:判断用户是否存在
        int count = userMapper.findByUsername(username);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        //step3:判断用户手机号和验证码是否相符


        String _phonecode= (String)request.getSession().getAttribute(username);
       if(_phonecode.equals(phonecode)==false)
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_ERROR.getCode(),ResponseCode.PHONECODE_ERROR.getMsg());
        //step4:返回结果
            request.getSession().removeAttribute(username);
            User user = userMapper.selectUserByUsername(username);
            request.setAttribute(user.getBoboNumber(),user);
//            System.out.println(user);
            return ServerResponse.createServerResponseBySucess();
    }

    /**
     * 发送验证码，根据status来进行不同的处理
     * @param username
     * @param status
     * @return
     */


    //status的值为0用于登陆、修改密码，1用于注册
    @Override
    public ServerResponse sendPhoneCode(HttpServletRequest request,String username, int status) {
        //step1:手机号的非空校验
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        //step2:结合status来判断手机号是否存在
        int count=userMapper.findByUsername(username);
        if(status==Const.SENDPHONECODE_LOGIN){//用于登陆和修改密码
            if(count==0)
                return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());

        }
        else if(status== Const.SENDPHONECODE_REGISTER){//用于注册
            if(count!=0)
                return ServerResponse.createServerResponseByFail(ResponseCode.USERANME_EXISTS.getCode(),ResponseCode.USERANME_EXISTS.getMsg());
        }
        //step3:给用户发送验证码并保存
        String phonecode = CreatePhoneCode.createRandom(true,6);
        HttpResponse httpResponse = SendPhoneCode.sendPhoneCode(username,phonecode);
        //step4:将手机号和验证码保存在session中,注意这里有一个时间，要设置一下session中的内容保存时间
        HttpSession session = request.getSession();
        session.setAttribute(username,phonecode);
        return ServerResponse.createServerResponseBySucess();
    }







    /**
     * 注册
     * @param username
     * @param phonecode
     * @param password
     * @param _password
     * @return
     */
    @Override
    public ServerResponse registeredLogic(HttpServletRequest request,String username,String phonecode,String password,String _password) {
        //写注册逻辑
        //step1:用户名、手机验证码、密码、_密码非空判断
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(phonecode==null||phonecode.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_NOT_EMPTY.getCode(),ResponseCode.PHONECODE_NOT_EMPTY.getMsg());
        if(password==null||password.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        if(_password==null||_password.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());



        //step2:判断用户名是否存在
        int count = userMapper.findByUsername(username);
        if(count!=0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERANME_EXISTS.getCode(),ResponseCode.USERANME_EXISTS.getMsg());
        //step3:判断用户名和手机号验证码是否相匹配
        String _phonecode=(String)request.getSession().getAttribute(username);
        if(_phonecode.equals(phonecode)==false)
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_ERROR.getCode(),ResponseCode.PHONECODE_ERROR.getMsg());
        request.getSession().removeAttribute(username);
        //step4:在前端完成两个密码的比较工作并约束，这里随机生成一个唯一的bobo_number，并且bobo_information创建一个bobo_number索引的新用户
        String bobo_name=BoboNumberUtils.generateShortUuid();
        String bobo_number="Bobo_"+bobo_name;
        User user = new User();
        user.setUsername(username);
        user.setBoboNumber(bobo_number);
        user.setPassword(MD5utils.getPwd(password));
        user.setRole(Const.CREATECOMMONUSER);
        int result = userMapper.insert(user);
        if(result==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.REGISTER_FAIL.getCode(),ResponseCode.REGISTER_FAIL.getMsg());



        UserInformation userInformation = new UserInformation();
        userInformation.setBoboName(bobo_name);
        userInformation.setBoboNumber(bobo_number);
        int result1 = userInformationMapper.insert(userInformation);
        if(result1==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.REGITTER_INIT_FAIL.getCode(),ResponseCode.REGITTER_INIT_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }


    /**
     *根据旧密码去修改当前用户密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public ServerResponse updatePswByPsw(String username, String oldPassword, String newPassword) {
        //step0:判断输入是否合法
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(oldPassword==null||oldPassword.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        if(newPassword==null||newPassword.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.NEW_PASSWORD_NOT_EMPTY.getCode(),ResponseCode.NEW_PASSWORD_NOT_EMPTY.getMsg());
        //step1:判断用户名是否存在
        int count = userMapper.findByUsername(username);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        //step2:判断旧密码是否正确
        User user = userMapper.findByUsernameAndPassword(username,MD5utils.getPwd(oldPassword));
        if(user==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getMsg());
        //step3:修改当前用户名对应的密码
        userMapper.updatePasswordByUsername(username,MD5utils.getPwd(newPassword));
        return ServerResponse.createServerResponseBySucess();
    }





    /**
     * 通过手机验证码修改密码时，身份验证接口
     * @param request
     * @param username
     * @param phonecode
     * @return
     */
    @Override
    public ServerResponse updatePswByPhoneCode(HttpServletRequest request, String username, String phonecode) {
        //step1:判断手机号和验证码非空
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(phonecode==null||phonecode.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_NOT_EMPTY.getCode(),ResponseCode.PHONECODE_NOT_EMPTY.getMsg());



        //step2:判断用户是否存在
        int count = userMapper.findByUsername(username);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        //step3:判断用户手机号和验证码是否相符
        String _phonecode= (String)request.getSession().getAttribute(username);
        if(_phonecode.equals(phonecode)==false)
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONECODE_ERROR.getCode(),ResponseCode.PHONECODE_ERROR.getMsg());
        //step4:返回结果
        request.getSession().removeAttribute(username);
        return ServerResponse.createServerResponseBySucess();
    }



    /**
     * 修改密码时，身份验证成功后进行修改密码操作
     * @param username
     * @param password
     * @return
     */
    @Override
    public ServerResponse updatePswByPhoneCodeFinal(String username, String password) {
        if(username==null||username.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        if(password==null||password.equals(""))
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        userMapper.updatePasswordByUsername(username,MD5utils.getPwd(password));
        return ServerResponse.createServerResponseBySucess();
    }


}
