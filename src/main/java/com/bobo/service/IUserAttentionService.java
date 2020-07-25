package com.bobo.service;

import com.bobo.utils.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface IUserAttentionService {


    /**
     * 关注接口，用户A关注用户B
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    ServerResponse AUserAttentionToBUser(String followBoboNumber,String befollowBoboNumber);

    /**
     * 取消关注接口，用户A取消关注用户B
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    ServerResponse AUserCancelAttentionToBUser(String followBoboNumber,String befollowBoboNumber);

    /**
     * 根据bobo_number
     * 获取用户的关注列表
     * @param followBoboNumber
     * @return
     */
    ServerResponse GetFocuesonList(String followBoboNumber);
}
