package com.bobo.controller;

import com.bobo.pojo.UserInformation;
import com.bobo.service.IUserInformationService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 与用户信息相关的接口
 */
@RestController
@RequestMapping("/userinformation/")
public class UserInformationController {


    @Autowired
    IUserInformationService userInformationService;

    //这里需要加上params,与前端进行对应，测试时可以不加，方便测试
    @PostMapping(value = "updateinformation.do")
    public ServerResponse updateUserInformationByBobo_number(UserInformation userInformation, HttpServletRequest request) {
        ServerResponse serverResponse = userInformationService.updateUserInformationByBobo_number(request,userInformation);
        return serverResponse;
    }
}
