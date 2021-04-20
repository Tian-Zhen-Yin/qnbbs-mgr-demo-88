package com.kgc.bbs.service.impl;

import com.kgc.bbs.beans.BbsSort;
import com.kgc.bbs.mapper.BbsSortMapper;
import com.kgc.bbs.service.BbsSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 */
@Service
public class BbsSortServiceImpl implements BbsSortService {

    @Autowired(required = false)
    private BbsSortMapper bbsSortMapper;

    @Override
    public List<BbsSort> queryAllBbsSort() {
        return bbsSortMapper.selectAllBbsSort();
    }
}
