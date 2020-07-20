package com.bobo.service.impl;

import com.bobo.common.ResponseCode;
import com.bobo.dao.UserInformationMapper;
import com.bobo.pojo.User;
import com.bobo.pojo.UserInformation;
import com.bobo.service.IUserInformationService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public class UserInformationService implements IUserInformationService {

    /**
     * 可以修改用户的基本信息，前端传入Bobo_number进行数据库信息表单的对应
     * @param userInformation
     * @return
     */
    @Autowired
    UserInformationMapper userInformationMapper;
    @Override
    public ServerResponse updateUserInformationByBobo_number(HttpServletRequest request,UserInformation userInformation) {
        User user  = (User)request.getSession().getAttribute(userInformation.getBoboNumber());
        if(user==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getMsg());
        int count = userInformationMapper.updateInformationByBobo_number(userInformation);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.UPDATE_INFORMATION_FAIL.getCode(),ResponseCode.UPDATE_INFORMATION_FAIL.getMsg());
        return  ServerResponse.createServerResponseBySucess();
    }
}
