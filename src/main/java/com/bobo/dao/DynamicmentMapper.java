package com.bobo.dao;

import com.bobo.pojo.Dynamicment;

public interface DynamicmentMapper {


    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户发布的动态，传入根据用户bobo_number而获取的头像地址和name,
     * 并且返回对应的id，便于进行发布的动态的图片存储操作
     * @param record
     * @return
     */
    int insert(Dynamicment record);


    int insertSelective(Dynamicment record);

    Dynamicment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dynamicment record);

    int updateByPrimaryKeyWithBLOBs(Dynamicment record);

    int updateByPrimaryKey(Dynamicment record);
}