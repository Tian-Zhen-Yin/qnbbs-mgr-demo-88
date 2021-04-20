package com.kgc.bbs.controller;

import com.kgc.bbs.beans.BbsDetail;
import com.kgc.bbs.beans.BbsSort;
import com.kgc.bbs.beans.form.BbsForm;
import com.kgc.bbs.service.BbsDetailService;
import com.kgc.bbs.service.BbsSortService;
import com.kgc.bbs.utils.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created on 2021-04-16.
 * <p>
 * Author: zhukang
 * <p>
 * Description: 论坛控制器入口
 */
@Controller
public class BbsController {

    @Autowired
    private BbsSortService bbsSortService;

    @Autowired
    private BbsDetailService bbsDetailService;

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 查询论坛列表
     */
    @RequestMapping("/bbsList")
    public String bbsList(@RequestParam(value = "sortId", defaultValue = "0") Integer sortId, Map<String, Object> map, HttpServletRequest request) throws UnsupportedEncodingException{

        // 查询所有的版区分类
        List<BbsSort> bbsSorts = bbsSortService.queryAllBbsSort();

        // 查询所有的帖子
        List<BbsDetail> bbsDetails = bbsDetailService.queryAllBbsDetail(sortId);

        // 存入模型数据
        map.put("bbsSorts", bbsSorts);
        map.put("bbsDetails", bbsDetails);
        map.put("msg", URLDecoder.decode(StringUtils.isEmpty(request.getParameter("msg")) ? "" : request.getParameter("msg"), "utf-8"));
        map.put("sortId", sortId);

        // 返回视图
        return "bbsList";
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 查询论坛列表，带分页
     */
    @RequestMapping("/bbsListUsePage")
    public String bbsListUsePage(BbsForm bbsForm, Map<String, Object> map, HttpServletRequest request) throws UnsupportedEncodingException{


        // 查询参数处理
        if(StringUtils.isEmpty(bbsForm.getSortId())){
            bbsForm.setSortId(0);
        }

        // 根据条件查询总数
        int totalCount = bbsDetailService.queryBbsDetailCount(bbsForm);

        // 分页参数处理
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(bbsForm.getPageSize());
        pageSupport.setTotalCount(totalCount);

        // 当前页码处理
        int currPageNo = bbsForm.getPageNo();
        if(currPageNo < 1 || pageSupport.getTotalPage() == 0){
            currPageNo = 1;
        } else if (currPageNo > pageSupport.getTotalPage()) {
            currPageNo = pageSupport.getTotalPage();
        }

        // 记录当前页码，用于展示的
        pageSupport.setCurrPageNo(currPageNo);

        // 修复请求页码，用于查询的
        bbsForm.setPageNo(currPageNo);

        // 根据分页参数查询列表数据
        List<BbsDetail> bbsDetails = bbsDetailService.queryBbsListUsePage(bbsForm);

        // 查询所有的版区分类
        List<BbsSort> bbsSorts = bbsSortService.queryAllBbsSort();

        // 存入模型数据
        map.put("bbsSorts", bbsSorts);
        map.put("bbsDetails", bbsDetails);
        map.put("page", pageSupport);
        map.put("msg", URLDecoder.decode(StringUtils.isEmpty(request.getParameter("msg")) ? "" : request.getParameter("msg"), "utf-8"));
        map.put("sortId", bbsForm.getSortId());
        map.put("title", bbsForm.getTitle());

        // 返回视图
        return "bbsList";
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 跳转添加帖子页面
     */
    @RequestMapping("/toAddBbsDetail")
    public String toAddBbsDetail(Map<String, Object> map){
        // 查询所有的版区分类
        map.put("bbsSorts", bbsSortService.queryAllBbsSort());
        return "bbsDetail";
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 执行添加帖子
     */
    @RequestMapping("/addBbsDetail")
    public String addBbsDetail(BbsDetail bbsDetail){
        // 执行新增
        if(bbsDetailService.addBbsDetail(bbsDetail)){
            return "redirect:bbsList?msg=success";
        }

        return "bbsDetail";
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 跳转修改帖子页面
     */
    @RequestMapping("/toModBbsDetail")
    public String toModBbsDetail(@RequestParam Integer id, Map<String, Object> map){
        // 查询所有的版区分类
        map.put("bbsSorts", bbsSortService.queryAllBbsSort());

        // 查询帖子详情
        map.put("bbsDetail", bbsDetailService.queryBbsDetailById(id));

        return "bbsModify";
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 执行修改帖子
     */
    @RequestMapping("/modBbsDetail")
    @ResponseBody
    public boolean modBbsDetail(BbsDetail bbsDetail){
        return bbsDetailService.modBbsDetail(bbsDetail);
    }

    /**
     * @author zhukang
     * @date zhukang
     * @return
     * @description 删除帖子
     */
    @RequestMapping("/delBbsDetail")
    public String delBbsDetail(@RequestParam Integer id) throws UnsupportedEncodingException {
        // 执行删除
        if(bbsDetailService.delBbsDetail(id)){
            return "redirect:bbsList?msg=" + URLEncoder.encode("删除成功", "utf-8");
        }

        return "redirect:bbsList?msg=" + URLEncoder.encode("删除失败", "utf-8");
    }
}
