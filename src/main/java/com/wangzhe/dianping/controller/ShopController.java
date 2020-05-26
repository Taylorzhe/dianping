package com.wangzhe.dianping.controller;

import com.mysql.cj.util.StringUtils;
import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.common.EmTrueError;
import com.wangzhe.dianping.common.FrontDisplay;
import com.wangzhe.dianping.model.CategoryModel;
import com.wangzhe.dianping.model.ShopModel;
import com.wangzhe.dianping.service.CategoryService;
import com.wangzhe.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： Wang Zhe
 * @date： 2020/3/30 17:33
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    //推荐服务V1.0
    @RequestMapping("/recommend")
    @ResponseBody
    public FrontDisplay recommend(@RequestParam(name = "longitude")BigDecimal longitude,
                                  @RequestParam(name = "latitude")BigDecimal latitude) throws BusinessException {
        if (longitude == null || latitude == null){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return FrontDisplay.create(shopModelList);
    }


    //搜索服务V1.0
    @RequestMapping("/search")
    @ResponseBody
    public FrontDisplay search(@RequestParam(name = "longitude")BigDecimal longitude,
                               @RequestParam(name = "latitude")BigDecimal latitude,
                               @RequestParam(name = "keyword")String keyword,
                               @RequestParam(name = "orderby", required = false)Integer orderby,
                               @RequestParam(name = "categoryId", required = false)Integer categoryId,
                               @RequestParam(name = "tags", required = false)String tags) throws BusinessException {
        if (StringUtils.isNullOrEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.search(longitude, latitude, keyword, orderby, categoryId, tags);
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String, Object>> tagsAggregation = shopService.searchGroupByTags(keyword, categoryId, tags);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("shop", shopModelList);
        resMap.put("category", categoryModelList);
        resMap.put("tags", tagsAggregation);
        return FrontDisplay.create(resMap);
    }
}

    //搜索服务v2.0
//    @RequestMapping("/search")
//    @ResponseBody
//    public FrontDisplay search(@RequestParam(name = "longitude")BigDecimal longitude,
//                               @RequestParam(name = "latitude")BigDecimal latitude,
//                               @RequestParam(name = "keyword")String keyword,
//                               @RequestParam(name = "orderby", required = false)Integer orderby,
//                               @RequestParam(name = "categoryId", required = false)Integer categoryId,
//                               @RequestParam(name = "tags", required = false)String tags) throws BusinessException, IOException {
//        if (StringUtils.isNullOrEmpty(keyword) || longitude == null || latitude == null){
//            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR);
//        }
//
//        Map<String, Object> result = shopService.searchES(longitude, latitude, keyword, orderby, categoryId, tags);
//        List<ShopModel> shopModelList = (List<ShopModel>) result.get("shop");
//        List<CategoryModel> categoryModelList = categoryService.selectAll();
//        List<Map<String, Object>> tagsAggregation = (List<Map<String, Object>>) result.get("tags");
//        Map<String, Object> resMap = new HashMap<>();
//        resMap.put("shop", shopModelList);
//        resMap.put("category", categoryModelList);
//        resMap.put("tags", tagsAggregation);
//        return FrontDisplay.create(resMap);
//    }
//}
