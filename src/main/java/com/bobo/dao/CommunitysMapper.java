package com.bobo.dao;

import com.bobo.pojo.Communitys;

public interface CommunitysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Communitys record);

    int insertSelective(Communitys record);

    Communitys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Communitys record);

    int updateByPrimaryKeyWithBLOBs(Communitys record);

    int updateByPrimaryKey(Communitys record);
}