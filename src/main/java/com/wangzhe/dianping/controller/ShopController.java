package com.wangzhe.dianping.controller;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.common.EmTrueError;
import com.wangzhe.dianping.common.FrontDisplay;
import com.wangzhe.dianping.model.ShopModel;
import com.wangzhe.dianping.service.CategoryService;
import com.wangzhe.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.prefs.BackingStoreException;

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
    public FrontDisplay recommend(@RequestParam(name = "longitude")BigDecimal longitude,
                                  @RequestParam(name = "latitude")BigDecimal latitude) throws BusinessException {
        if (longitude == null || latitude == null){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return FrontDisplay.create(shopModelList);
    }
}
