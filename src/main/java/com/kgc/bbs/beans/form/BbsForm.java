package com.kgc.bbs.beans.form;

import lombok.Data;

/**
 * Created on 2021-04-17.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 论坛查询实体
 */
@Data
public class BbsForm extends BaseForm {
    private Integer sortId;
    private String title;

}
