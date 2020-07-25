package com.bobo.service.impl;

import com.bobo.common.ResponseCode;
import com.bobo.dao.CategoryMapper;
import com.bobo.pojo.Category;
import com.bobo.service.ICategoryService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    /**
     * 根据id来查询一级子类别
     * @param categoryId
     * @return
     */
    @Override
    public ServerResponse findSubCategoryById(Integer categoryId) {
        if(categoryId==null)
            return ServerResponse.createServerResponseByFail(ResponseCode.PARAMTER_NOT_EMPTY.getCode(),ResponseCode.PARAMTER_NOT_EMPTY.getMsg());
       List<Category> categoryList = categoryMapper.findSubCategoryById(categoryId);
       return ServerResponse.createServerResponseBySucess(categoryList);
    }
}
