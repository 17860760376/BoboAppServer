package com.bobo.dao;

import com.bobo.pojo.CommunityActivitys;

public interface CommunityActivitysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunityActivitys record);

    int insertSelective(CommunityActivitys record);

    CommunityActivitys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunityActivitys record);

    int updateByPrimaryKeyWithBLOBs(CommunityActivitys record);

    int updateByPrimaryKey(CommunityActivitys record);
}