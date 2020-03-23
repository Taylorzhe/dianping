package com.wangzhe.dianping.common;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 20:21
 * @description： 前端页面常见的错误
 * @modifiedBy：
 * @version: 1.0
 */
public class CommonError {

    //错误码
    private Integer errCode;

    //错误的描述
    private String errMsg;


    public CommonError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonError(EmTrueError emTrueError) {
        this.errCode = emTrueError.getErrCode();
        this.errMsg = emTrueError.getErrMsg();
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
