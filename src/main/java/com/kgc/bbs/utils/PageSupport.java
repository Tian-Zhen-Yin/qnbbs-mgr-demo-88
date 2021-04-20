package com.kgc.bbs.utils;

import lombok.Data;

/**
 * 分页处理类
 *
 * @author zhukang
 */
@Data
public class PageSupport {

    /**
     * 总条数
     */
    private int totalCount;

    /**
     * 页面容量-每页展示数据条数
     */
    private int pageSize;

    /**
     * 当前页码-记录当前展示到第几页
     */
    private int currPageNo;

    /**
     * 总页数-根据总条数和页面容量计算出来的
     */
    private int totalPage;


    public void setTotalCount(int totalCount) {
        // 当设置总条数的时候，可以确定总页数
        if (totalCount > 0) {
            this.totalCount = totalCount;

            // 计算总页数
            this.setTotalPage(this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : (this.totalCount / this.pageSize + 1));
        }
    }

}
