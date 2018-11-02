package com.demo.controller;

import com.demo.core.common.Paginator;
import com.demo.core.common.ResponseBuilder;
import com.demo.entity.GoodsInfo;
import com.demo.enu.CategoryEnum;
import com.demo.service.GoodsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goods")
public class GoodsInfoController {

    private final static Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    @Autowired
    private GoodsInfoService goodsInfoService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Paginator paginator, GoodsInfo record){
        try {

            paginator.setItemsPerPage(10);
            paginator.setParams(record);

            paginator = goodsInfoService.page(paginator);
            request.setAttribute("goodsList", paginator.getResults());

            request.setAttribute("paginator", paginator);
            request.setAttribute("categoryMap", CategoryEnum.getMap());

        } catch (Exception e) {
            logger.error("index error:{}", e);
        }
        return "goods/goods_index";
    }

    @RequestMapping("/toAdd")
    public String detail(HttpServletRequest request){
        request.setAttribute("categoryMap", CategoryEnum.getMap());
        return "goods/goods_detail";
    }

    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Integer id){
        try {

            request.setAttribute("categoryMap", CategoryEnum.getMap());
            request.setAttribute("record", goodsInfoService.selectById(id));

        } catch (Exception e) {
            logger.error("detail error:{}", e);
        }
        return "goods/goods_detail";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(GoodsInfo record){
        try {

            goodsInfoService.save(record);

            return ResponseBuilder.buildSuccess();
        } catch (Exception e) {
            logger.error("save error:{}", e);
        }
        return ResponseBuilder.buildError();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer id){
        try {

            goodsInfoService.delete(id);

            return ResponseBuilder.buildSuccess();
        } catch (Exception e) {
            logger.error("delete error:{}", e);
        }
        return ResponseBuilder.buildError();
    }

}
