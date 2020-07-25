package com.bobo.dao;

import com.bobo.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;

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




    /**
     * 当A关注B时，同时修改UserInformation中的值
     */
    //粉丝数+1，好友数+1
    int updateFriendAddAndFanAdd(@Param("boboNumber") String boboNumber);
    //粉丝数+1
    int updateFansAdd(@Param("boboNumber") String boboNumber);
    //关注数+1
    int updateFocusonUserAdd(@Param("boboNumber") String boboNumber);
    //关注数+1，好友数+1
    int updateFocusonAddAndFriendAdd(@Param("boboNumber") String boboNumber);




    /**
     * 当A取消关注B时，同时修改UserInformation中的值
     * @param boboNumber
     * @return
     */
    //粉丝数-1，好友数-1
    int updateFriendReduceFanReduce(@Param("boboNumber") String boboNumber);
    //粉丝数-1
    int updateFansReduce(@Param("boboNumber") String boboNumber);
    //关注数-1
    int updateFocusonUserReduce(@Param("boboNumber") String boboNumber);
    //关注数-1，好友数-1
    int updateFocusonReduceAndFriendReduce(@Param("boboNumber") String boboNumber);



    /**
     * 根据bobo_number,获取boboName和用户头像，便于动态内容中的展示
     * @param boboNumber
     * @return
     */
    UserInformation findBybobo_number(@Param("boboNumber") String boboNumber);

}