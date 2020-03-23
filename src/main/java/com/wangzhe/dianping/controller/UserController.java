package com.wangzhe.dianping.controller;

import com.wangzhe.dianping.common.FrontDisplay;
import com.wangzhe.dianping.model.UserModel;
import com.wangzhe.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 19:16
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Controller("/user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/get")
    @ResponseBody
    public FrontDisplay getUser(@RequestParam(name = "id") Integer id){
        UserModel userModel = userService.getUser(id);
        return FrontDisplay.create(userModel);
    }
}
