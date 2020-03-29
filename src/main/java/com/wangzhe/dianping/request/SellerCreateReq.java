package com.wangzhe.dianping.request;

import javax.validation.constraints.NotBlank;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 22:28
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class SellerCreateReq {

    @NotBlank(message = "商户名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
