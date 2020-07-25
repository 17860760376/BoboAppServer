package com.bobo.dao;

import com.bobo.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);


    /**
     * 根据id来查询一级子类别
     * @param categoryId
     * @return
     */
    List<Category> findSubCategoryById(@Param("categoryId")Integer categoryId);
}