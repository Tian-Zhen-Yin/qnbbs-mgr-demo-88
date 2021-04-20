package com.kgc.bbs.service;

import com.kgc.bbs.beans.BbsDetail;
import com.kgc.bbs.beans.form.BbsForm;

import java.util.List;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 帖子业务接口
 */
public interface BbsDetailService {

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据讨论版区查询帖子列表
     */
    List<BbsDetail> queryAllBbsDetail(Integer sortId);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 添加帖子
     */
    boolean addBbsDetail(BbsDetail bbsDetail);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据ID查询帖子详情
     */
    BbsDetail queryBbsDetailById(Integer id);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 修改帖子
     */
    boolean modBbsDetail(BbsDetail bbsDetail);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 删除帖子
     */
    boolean delBbsDetail(Integer id);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据条件查询帖子总数
     */
    int queryBbsDetailCount(BbsForm bbsForm);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据讨论版区查询帖子列表
     */
    List<BbsDetail> queryBbsListUsePage(BbsForm bbsForm);
}
