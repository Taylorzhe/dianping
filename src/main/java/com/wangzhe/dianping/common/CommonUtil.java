package com.wangzhe.dianping.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author： Wang Zhe
 * @date： 2020/3/24 10:29
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class CommonUtil {

    public static String processErrorString(BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError :
                bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage()).append(",");
        }
        return sb.substring(0, sb.length()-1);
    }
}
