package com.bobo.service.impl;

import com.bobo.dao.UserAttentionMapper;
import com.bobo.dao.UserInformationMapper;
import com.bobo.pojo.UserAttention;
import com.bobo.service.IUserAttentionService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserAttentionService implements IUserAttentionService {



    @Autowired
    UserAttentionMapper userAttentionMapper;
    @Autowired
    UserInformationMapper userInformationMapper;
    /**
     * 用户A关注用户B接口实现
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    @Override
    public ServerResponse AUserAttentionToBUser(String followBoboNumber, String befollowBoboNumber) {
        int count = userAttentionMapper.findByAbobo_numberAndBbobo_number(followBoboNumber, befollowBoboNumber);
        //用户B未关注用户A
        if(count==0){
            userAttentionMapper.insertAFocusonB(followBoboNumber, befollowBoboNumber);
            userInformationMapper.updateFocusonUserAdd(followBoboNumber);
            userInformationMapper.updateFansAdd(befollowBoboNumber);
        }//用户B已经关注用户A
        else {
            userInformationMapper.updateFriendAddAndFanAdd(befollowBoboNumber);
            userInformationMapper.updateFocusonAddAndFriendAdd(followBoboNumber);
            userAttentionMapper.updateFocusonToFriends(followBoboNumber, befollowBoboNumber);
        }
        return ServerResponse.createServerResponseBySucess();
    }




    /**
     * 用户A取消关注用户B接口实现
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    @Override
    public ServerResponse AUserCancelAttentionToBUser(String followBoboNumber, String befollowBoboNumber) {
        int count = userAttentionMapper.findIfBUserFocusonAUser(followBoboNumber, befollowBoboNumber);
//        System.out.println(count);

        //用户B也关注了用户A
        if(count!=0){
            userAttentionMapper.deleteByCancelAUserFocusonBUser(followBoboNumber, befollowBoboNumber);
            userAttentionMapper.insertAFocusonB(befollowBoboNumber,followBoboNumber);
            userInformationMapper.updateFriendReduceFanReduce(befollowBoboNumber);
            userInformationMapper.updateFocusonReduceAndFriendReduce(followBoboNumber);
        }//用户B未关注用户A
        else {
            userInformationMapper.updateFocusonUserReduce(followBoboNumber);
            userInformationMapper.updateFansReduce(befollowBoboNumber);
            userAttentionMapper.deleteByCancelAUserFocusonBUser(followBoboNumber, befollowBoboNumber);
        }
        return ServerResponse.createServerResponseBySucess();
    }


    /**
     * 根据bobo_number
     * 获取用户的关注列表
     * @param followBoboNumber
     * @return
     */
    @Override
    public ServerResponse GetFocuesonList(String followBoboNumber) {

        List<UserAttention> userAttentionList = userAttentionMapper.getFocusonList(followBoboNumber);
        List<String> AttentionList = new ArrayList<>();
        for(UserAttention userAttention : userAttentionList){
            if(userAttention.getFollowBoboNumber().equals(followBoboNumber)==false)
                AttentionList.add(userAttention.getFollowBoboNumber());
            else AttentionList.add(userAttention.getBefollowBoboNumber());
        }
        return  ServerResponse.createServerResponseBySucess(AttentionList);
    }
}
