package com.wangzhe.dianping.service;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.model.SellerModel;

import java.util.List;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 21:33
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface SellerService {

    SellerModel create(SellerModel sellerModel);

    SellerModel get(Integer id);

    List<SellerModel> selectAll();

    SellerModel changeStatus(Integer id, Integer disabledFlag) throws BusinessException;
}
