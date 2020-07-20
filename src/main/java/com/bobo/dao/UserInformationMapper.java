package com.bobo.dao;

import com.bobo.pojo.UserInformation;

public interface UserInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    UserInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInformation record);

    int updateByPrimaryKey(UserInformation record);

    /**
     * 根据bobo_number去修改用户信息表
     */
    int updateInformationByBobo_number(UserInformation userInformation);
}