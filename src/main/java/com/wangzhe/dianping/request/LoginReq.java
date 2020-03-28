package com.wangzhe.dianping.request;

import javax.validation.constraints.NotBlank;

/**
 * @author： Wang Zhe
 * @date： 2020/3/27 12:14
 * @description： 有关用户登陆前端传回来的request
 * @modifiedBy：
 * @version: 1.0
 */
public class LoginReq {

    @NotBlank(message = "手机号不能为空")
    private String telephone;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
