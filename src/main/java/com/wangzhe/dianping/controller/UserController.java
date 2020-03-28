package com.wangzhe.dianping.controller;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.common.CommonUtil;
import com.wangzhe.dianping.common.EmTrueError;
import com.wangzhe.dianping.common.FrontDisplay;
import com.wangzhe.dianping.model.UserModel;
import com.wangzhe.dianping.request.LoginReq;
import com.wangzhe.dianping.request.RegisterReq;
import com.wangzhe.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

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

    private static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("index")
    public ModelAndView index(){
        String userName = "wangzhe";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name", userName);
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public FrontDisplay getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null){
            throw new BusinessException(EmTrueError.NO_OBJECT_FOUND);
        }else {
            return FrontDisplay.create(userModel);
        }
    }

    @RequestMapping("register")
    @ResponseBody
    public FrontDisplay register(@Valid @RequestBody RegisterReq registerReq, BindingResult bindingResult) throws NoSuchAlgorithmException, BusinessException {
        if (bindingResult.hasErrors()){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel registerUser = new UserModel();
        registerUser.setTelephone(registerReq.getTelephone());
        registerUser.setNickName(registerReq.getNickName());
        registerUser.setPassword(registerReq.getPassword());
        registerUser.setGender(registerReq.getGender());

        UserModel resUserModel = userService.register(registerUser);
        return FrontDisplay.create(resUserModel);
    }

    @RequestMapping("/login")
    @ResponseBody
    public FrontDisplay login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) throws BusinessException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getTelephone(), loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);

        return FrontDisplay.create(userModel);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public FrontDisplay logout() throws BusinessException, NoSuchAlgorithmException {
        httpServletRequest.getSession().invalidate();
        return FrontDisplay.create(null);
    }

    //获取当前用户信息
    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public FrontDisplay getCurrentUser(){
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return FrontDisplay.create(userModel);
    }
}
