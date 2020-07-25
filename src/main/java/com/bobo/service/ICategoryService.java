package com.bobo.service;

import com.bobo.pojo.Category;
import com.bobo.utils.ServerResponse;

import java.util.List;

public interface ICategoryService {
    /**
     * 根据id来查询一级类别
     * @param categoryId
     * @return
     */
    ServerResponse findSubCategoryById(Integer categoryId);
}
