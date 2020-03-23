package com.wangzhe.dianping.common;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 20:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public FrontDisplay doError(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse, Exception ex) {
        if (ex instanceof BusinessException) {
            return FrontDisplay.create(((BusinessException) ex).getCommonError(), "fail");
        } else if (ex instanceof NoHandlerFoundException) {
            CommonError commonError = new CommonError(EmTrueError.NO_HANDLER_FOUND);
            return FrontDisplay.create(commonError, "fail");
        } else if (ex instanceof ServletRequestBindingException) {
            CommonError commonError = new CommonError(EmTrueError.BIND_EXCEPTION_ERROR);
            return FrontDisplay.create(commonError, "fail");
        } else {
            CommonError commonError = new CommonError(EmTrueError.UNKNOWN_ERROR);
            return FrontDisplay.create(commonError, "fail");
        }

    }
}
