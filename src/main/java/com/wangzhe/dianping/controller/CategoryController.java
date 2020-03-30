package com.wangzhe.dianping.controller;

import com.wangzhe.dianping.common.FrontDisplay;
import com.wangzhe.dianping.model.CategoryModel;
import com.wangzhe.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author： Wang Zhe
 * @date： 2020/3/29 17:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Controller("category")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public FrontDisplay list(){
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        return FrontDisplay.create(categoryModelList);
    }
}
