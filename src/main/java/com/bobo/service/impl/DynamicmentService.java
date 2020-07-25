package com.bobo.service.impl;

import com.bobo.common.Const;
import com.bobo.common.ResponseCode;
import com.bobo.dao.DynamicmentMapper;
import com.bobo.dao.UserInformationMapper;
import com.bobo.pojo.Dynamicment;
import com.bobo.pojo.UserInformation;
import com.bobo.service.IDynamicmentService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicmentService implements IDynamicmentService {

    /**
     * 实现将动态内容保存到数据库中的操作，并且返回创建的对应的数据的id,用于动态内容中的图片的保存
     * @param dynamicment
     * @return
     */

    @Autowired
    UserInformationMapper userInformationMapper;
    @Autowired
    DynamicmentMapper dynamicmentMapper;
    @Override
    public ServerResponse insertDynamicment(Dynamicment dynamicment) {
        Integer id = null;
        if(dynamicment.getPublisherBoboNumber()==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.DYNAMICMENT_BOBONUMBER_NOT_EMOTY.getCode(),ResponseCode.DYNAMICMENT_BOBONUMBER_NOT_EMOTY.getMsg());
        String bobo_number = dynamicment.getPublisherBoboNumber();
        UserInformation userInformation = userInformationMapper.findBybobo_number(bobo_number);
        dynamicment.setPublisherName(userInformation.getBoboName());
        dynamicment.setPublisherPort(userInformation.getBoboProfilePhone());
        dynamicment.setDynamicmentPariserNumber(Const.INITIALIZATION_PARAMETER);
        dynamicment.setDynamicCommentNumber(Const.INITIALIZATION_PARAMETER);
        dynamicment.setDynamicTranmitNumber(Const.INITIALIZATION_PARAMETER);
        dynamicmentMapper.insert(dynamicment);
        id = dynamicment.getId();
        return  ServerResponse.createServerResponseBySucess(id);
    }

    /**
     * 根据id来删除对应的动态
     * @param dynamicmentId
     * @return
     */
    @Override
    public ServerResponse deleteDynamicment(Integer dynamicmentId) {
        int count = dynamicmentMapper.deleteByPrimaryKey(dynamicmentId);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.DYNAMICMNET_DELETE_FAIL.getCode(),ResponseCode.DYNAMICMNET_DELETE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }
}
