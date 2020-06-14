package com.bobo.dao;

import com.bobo.pojo.ActivityPicture;

public interface ActivityPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityPicture record);

    int insertSelective(ActivityPicture record);

    ActivityPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityPicture record);

    int updateByPrimaryKey(ActivityPicture record);
}