package com.bobo.controller;

import com.bobo.service.IUserAttentionService;
import com.bobo.service.impl.UserAttentionService;
import com.bobo.utils.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/attention/")
public class UserAttentionController {

    @Autowired
    IUserAttentionService userAttentionService;

    /**
     * 用户关注接口，用户A关注用户B
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    @GetMapping(value = "focuson.do")
    public ServerResponse userAttention(String followBoboNumber, String befollowBoboNumber){
        ServerResponse serverResponse = userAttentionService.AUserAttentionToBUser(followBoboNumber, befollowBoboNumber);
        return  serverResponse;
    }




    /**
     * 用户取消关注接口，用户A取消关注用户B
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    @GetMapping(value = "cancel/focuson.do")
    public ServerResponse userCancelAttention(String followBoboNumber, String befollowBoboNumber){
        ServerResponse serverResponse = userAttentionService.AUserCancelAttentionToBUser(followBoboNumber, befollowBoboNumber);
        return  serverResponse;
    }
}
