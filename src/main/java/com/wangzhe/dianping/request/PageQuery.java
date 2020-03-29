package com.wangzhe.dianping.request;

/**
 * @author： Wang Zhe
 * @date： 2020/3/28 23:26
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class PageQuery {

    private Integer page = 1;
    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
