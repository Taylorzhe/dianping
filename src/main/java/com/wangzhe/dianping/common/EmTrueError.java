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
    NO_OBJECT_FOUND(10001, "请求对象不存在"),;

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
