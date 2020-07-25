package com.bobo.controller;


import com.bobo.service.ICategoryService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Category/")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("{categoryId}")
    public ServerResponse findSubCategory(@PathVariable("categoryId") Integer categoryId){
        return iCategoryService.findSubCategoryById(categoryId);
    }
}
