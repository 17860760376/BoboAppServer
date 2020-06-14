package com.bobo.dao;

import com.bobo.pojo.Community_picture;

public interface Community_pictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Community_picture record);

    int insertSelective(Community_picture record);

    Community_picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Community_picture record);

    int updateByPrimaryKey(Community_picture record);
}