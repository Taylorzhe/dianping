package com.wangzhe.dianping.service;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.model.CategoryModel;

import java.util.List;

/**
 * @author： Wang Zhe
 * @date： 2020/3/29 17:20
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    CategoryModel get(Integer id);

    List<CategoryModel> selectAll();

    Integer countAllCategory();
}
