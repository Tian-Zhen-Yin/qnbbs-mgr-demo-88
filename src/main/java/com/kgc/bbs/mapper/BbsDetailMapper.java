package com.kgc.bbs.mapper;

import com.kgc.bbs.beans.BbsDetail;
import com.kgc.bbs.beans.form.BbsForm;

import java.util.List;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 帖子mapper接口
 */
public interface BbsDetailMapper {

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据讨论版区查询帖子列表
     */
    List<BbsDetail> selectAllBbsDetail(Integer sortId);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 插入帖子详情
     */
    int insertBbsDetail(BbsDetail bbsDetail);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 查询帖子详情
     */
    BbsDetail selectBbsDetailById(Integer id);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 修改帖子详情
     */
    int updateBbsDetail(BbsDetail bbsDetail);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 删除帖子详情
     */
    int deleteBbsDetail(Integer id);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据条件查询帖子总数
     */
    int selectBbsDetailCount(BbsForm bbsForm);

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 根据条件查询帖子分页数据
     */
    List<BbsDetail> selectBbsDetailUsePage(BbsForm bbsForm);
}
