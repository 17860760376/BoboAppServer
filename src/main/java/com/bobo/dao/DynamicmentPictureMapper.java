package com.bobo.dao;

import com.bobo.pojo.DynamicmentPicture;
import org.apache.ibatis.annotations.Param;

public interface DynamicmentPictureMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据动态表中对应的id，来插入动态内容对应的图片
     * @param record
     * @return
     */
    int insert(DynamicmentPicture record);

    int insertSelective(DynamicmentPicture record);

    DynamicmentPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DynamicmentPicture record);

    int updateByPrimaryKey(DynamicmentPicture record);

    /**
     * 根据dynamicmentId来删除要删除的动态对应的图片
     * @param dynamicmentId
     * @return
     */
    int deleteBydynamicmentId(@Param("dynamicmentId") Integer dynamicmentId);
}