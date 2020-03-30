package com.wangzhe.dianping.service;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author： Wang Zhe
 * @date： 2020/3/29 19:22
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;

    ShopModel get(Integer id);

    List<ShopModel> selectAll();

    Integer countAllShop();

    List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude);
}
