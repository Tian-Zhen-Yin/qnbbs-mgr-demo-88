package com.kgc.bbs.service.impl;

import com.kgc.bbs.beans.BbsDetail;
import com.kgc.bbs.beans.form.BbsForm;
import com.kgc.bbs.mapper.BbsDetailMapper;
import com.kgc.bbs.service.BbsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 */
@Service
public class BbsDetailServiceImpl implements BbsDetailService {

    @Autowired(required = false)
    private BbsDetailMapper bbsDetailMapper;

    @Override
    public List<BbsDetail> queryAllBbsDetail(Integer sortId) {
        return bbsDetailMapper.selectAllBbsDetail(sortId);
    }

    @Override
    public boolean addBbsDetail(BbsDetail bbsDetail) {
        return bbsDetailMapper.insertBbsDetail(bbsDetail) > 0;
    }

    @Override
    public BbsDetail queryBbsDetailById(Integer id) {
        return bbsDetailMapper.selectBbsDetailById(id);
    }

    @Override
    public boolean modBbsDetail(BbsDetail bbsDetail) {
        return bbsDetailMapper.updateBbsDetail(bbsDetail) > 0;
    }

    @Override
    public boolean delBbsDetail(Integer id) {
        return bbsDetailMapper.deleteBbsDetail(id) > 0;
    }

    @Override
    public int queryBbsDetailCount(BbsForm bbsForm) {
        return bbsDetailMapper.selectBbsDetailCount(bbsForm);
    }

    @Override
    public List<BbsDetail> queryBbsListUsePage(BbsForm bbsForm) {
        return bbsDetailMapper.selectBbsDetailUsePage(bbsForm);
    }
}
