package com.wangzhe.dianping.controller.admin;

import com.mysql.cj.util.StringUtils;
import com.wangzhe.dianping.common.AdminPermission;
import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.common.EmTrueError;
import com.wangzhe.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 19:18
 * @description： 后台管理员模块
 * @modifiedBy：
 * @version: 1.0
 */
@Controller("admin/admin")
@RequestMapping("admin/admin")
public class AdminController {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String password;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("admin/admin/index");
        modelAndView.addObject("userCount", userService.amountOfUsers());
        modelAndView.addObject("CONTROLLER_NAME", "admin");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage(){
        ModelAndView modelAndView = new ModelAndView("admin/admin/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "email")String email,
                              @RequestParam(name = "password")String password) throws BusinessException, NoSuchAlgorithmException {
        if (StringUtils.isNullOrEmpty(email) || StringUtils.isNullOrEmpty(password)){
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR, "用户名或密码不能为空");
        }
        if (email.equals(this.email) && encodeByMD5(password).equals(this.password)){
            //登陆成功
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION, email);
            return "redirect:/admin/admin/index";
        }else {
            //登陆失败
            throw new BusinessException(EmTrueError.PARAMETER_VALIDATION_ERROR, "用户名或密码错误");
        }
    }

    private String encodeByMD5(String str) throws NoSuchAlgorithmException {
        //确认计算方法MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}
