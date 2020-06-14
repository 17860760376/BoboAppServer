package com.bobo.dao;

import com.bobo.pojo.DynamicmentPicture;

public interface DynamicmentPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DynamicmentPicture record);

    int insertSelective(DynamicmentPicture record);

    DynamicmentPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DynamicmentPicture record);

    int updateByPrimaryKey(DynamicmentPicture record);
}