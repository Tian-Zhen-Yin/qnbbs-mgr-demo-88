package com.kgc.bbs.beans;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 论坛详情
 */
@Data
public class BbsDetail {
    private Integer id;
    private Integer sortId;
    private String title;
    private String detail;
    private String author;
    private Date createDate;
    private Integer replyCount;
}
