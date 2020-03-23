package com.wangzhe.dianping.common;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 20:07
 * @description： 前端页面所展示的信息
 * @modifiedBy：
 * @version: 1.0
 */
public class FrontDisplay {

    //表明对应请求返回的状态，"success"或"fail"
    private String status;

    //若status=success时，表明对应返回的json类数据
    //若status=fail时，表明对应的错误码
    private Object data;

    
    public static FrontDisplay create(Object result){
        return FrontDisplay.create(result, "success");
    }

    /**
     * 前端展示的请求返回的状态，和json数据
     * @param result 从数据库中返回的数据
     * @param status 请求返回的状态
     * @return 前端展示
     */
    public static FrontDisplay create(Object result, String status){
        FrontDisplay frontDisplay = new FrontDisplay();
        frontDisplay.setStatus(status);
        frontDisplay.setData(result);
        return frontDisplay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
