package com.bobo.dao;

import com.bobo.pojo.Dynamicment;

public interface DynamicmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamicment record);

    int insertSelective(Dynamicment record);

    Dynamicment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dynamicment record);

    int updateByPrimaryKeyWithBLOBs(Dynamicment record);

    int updateByPrimaryKey(Dynamicment record);
}