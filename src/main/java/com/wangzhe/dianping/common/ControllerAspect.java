package com.wangzhe.dianping.common;

import com.wangzhe.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 19:50
 * @description： 再
 * @modifiedBy：
 * @version: 1.0
 */
@Aspect
@Configuration
public class ControllerAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    /**
     * 在com.wangzhe.dianping.controller.admin这个包下的所有有RequestMapping标签的方法前加入切面
     * @param joinPoint 加入切面
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.wangzhe.dianping.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if (adminPermission == null){
            //公共方法
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
        //判断管理员是否登录
        String email = (String) httpServletRequest.getSession().getAttribute(AdminController.CURRENT_ADMIN_SESSION);
        if (email == null){
            if (adminPermission.produceType().equals("text/html")){
                httpServletResponse.sendRedirect("/admin/admin/loginpage");
                return null;
            }else {
                CommonError commonError = new CommonError(EmTrueError.ADMIN_SHOULD_LOGIN);
                return FrontDisplay.create(commonError, "fail");
            }
        }else {
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
    }
}
