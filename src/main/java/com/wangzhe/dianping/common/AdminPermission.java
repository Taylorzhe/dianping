package com.wangzhe.dianping.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 19:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {

    String produceType() default "text/html";
}
