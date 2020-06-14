package com.bobo.dao;

import com.bobo.pojo.UserAttention;

public interface UserAttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    UserAttention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}