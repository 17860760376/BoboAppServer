package com.bobo.dao;

import com.bobo.pojo.UserAttention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    UserAttention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);

    /**
     * A关注用户B时进行的数据库操作
     */



    /**
     * 前端传来A——>B时，判断B是否已将关注A
     * @param followBoboNumber
     * @param befollowBoboNumber
     * @return
     */
    int findByAbobo_numberAndBbobo_number(@Param("followBoboNumber") String followBoboNumber,@Param("befollowBoboNumber") String befollowBoboNumber);
    /**
     * 如果B——>A,那么将B——>A 0 那条语句改为B——>A 1
     */
    int updateFocusonToFriends(@Param("followBoboNumber") String followBoboNumber,@Param("befollowBoboNumber") String befollowBoboNumber);
    /**
     * 如果B没有关注A，那么增加A B 0语句
     */
    int insertAFocusonB(@Param("followBoboNumber") String followBoboNumber,@Param("befollowBoboNumber") String befollowBoboNumber);


    /**
     * 用户A取消关注用户B接口，查询用户B是否也关注用户A
     */
    int findIfBUserFocusonAUser(@Param("followBoboNumber") String followBoboNumber,@Param("befollowBoboNumber") String befollowBoboNumber);



    /**
     *删除关注用户接口操作，删除A,B,1||B,A,1||A,B,0
     *即取消用户A关注用户B
     */
    int deleteByCancelAUserFocusonBUser(@Param("followBoboNumber") String followBoboNumber,@Param("befollowBoboNumber") String befollowBoboNumber);


    /**
     * 修改关注状态，使B用户单独关注用户A
     * 修改参数值，直接调用insertAFocusonB接口即可
     */

    List<UserAttention> getFocusonList(@Param("followBoboNumber") String boboNumber);
}