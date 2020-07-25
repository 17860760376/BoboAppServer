package com.bobo.service;

import com.bobo.pojo.UserInformation;
import com.bobo.utils.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface IUserInformationService {

    /**
     * 修改用户基本信息的接口，根据前端提供的信息和对应的bobo_number来进行判断
     * @param request
     * @param userInformation
     * @return
     */
    ServerResponse updateUserInformationByBobo_number(HttpServletRequest request,UserInformation userInformation);


}
