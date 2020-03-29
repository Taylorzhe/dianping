package com.wangzhe.dianping.common;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 20:24
 * @description： 枚举类，对应的是业务中具体的错误还有错误描述
 * @modifiedBy：
 * @version: 1.0
 */
public enum EmTrueError {

    //通常用错误类型10000开头
    NO_OBJECT_FOUND(10001, "请求对象不存在"),
    UNKNOWN_ERROR(10002,"未知错误"),
    NO_HANDLER_FOUND(10003,"找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(10004,"请求参数错误"),
    PARAMETER_VALIDATION_ERROR(10005,"请求参数校验失败"),

    //用户服务相关的错误类型20000开头
    REGISTER_DUP_FAIL(20001,"用户已存在"),
    LOGIN_FAIL(20002,"手机号或密码错误"),

    //admin相关错误
    ADMIN_SHOULD_LOGIN(30001, "管理员需要先登录");

    //错误码
    private Integer errCode;

    //错误的描述
    private String errMsg;

    EmTrueError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
