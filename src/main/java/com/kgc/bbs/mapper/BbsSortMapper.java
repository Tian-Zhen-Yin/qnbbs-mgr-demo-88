package com.kgc.bbs.mapper;

import com.kgc.bbs.beans.BbsSort;

import java.util.List;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 讨论版区mapper接口
 */
public interface BbsSortMapper {

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 查询所有的讨论版区
     */
    List<BbsSort> selectAllBbsSort();
}
