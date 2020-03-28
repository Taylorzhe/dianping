package com.wangzhe.dianping.common;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 20:37
 * @description： 业务中出现的异常
 * @modifiedBy：
 * @version: 1.0
 */
public class BusinessException extends Exception{

    private CommonError commonError;

    public BusinessException(EmTrueError emTrueError){
        super();
        this.commonError = new CommonError(emTrueError);
    }

    public BusinessException(EmTrueError emTrueError, String essMsg){
        super();
        this.commonError = new CommonError(emTrueError);
        this.commonError.setErrMsg(essMsg);
    }

    public CommonError getCommonError() {
        return commonError;
    }
}
