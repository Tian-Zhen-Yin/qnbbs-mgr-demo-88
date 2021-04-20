package com.kgc.bbs.beans.form;

import lombok.Data;

/**
 * Created on 2021-04-17.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 请求参数基类
 */
@Data
public class BaseForm  {
    private Integer pageNo = 1;
    private Integer pageSize = 3;
}
