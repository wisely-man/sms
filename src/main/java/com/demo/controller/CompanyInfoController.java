package com.demo.controller;

import com.demo.core.common.Paginator;
import com.demo.core.common.ResponseBuilder;
import com.demo.entity.CompanyInfo;
import com.demo.service.CompanyInfoService;
import com.demo.service.GoodsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyInfoController {

    private final static Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);

    @Autowired
    private CompanyInfoService companyInfoService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Paginator paginator, CompanyInfo record){

        try {

            paginator.setItemsPerPage(10);
            paginator.setParams(record);

            paginator = companyInfoService.page(paginator);
            request.setAttribute("companyList", paginator.getResults());

            request.setAttribute("paginator", paginator);

        } catch (Exception e) {
            logger.error("index error:{}", e);
        }
        return "company/company_index";
    }

    @RequestMapping("/toAdd")
    public String detail(){
        return "company/company_detail";
    }

    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Integer id){
        try {

            request.setAttribute("record", companyInfoService.selectById(id));

        } catch (Exception e) {
            logger.error("detail error:{}", e);
        }
        return "company/company_detail";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(CompanyInfo record){
        try {

            companyInfoService.save(record);

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

            companyInfoService.delete(id);

            return ResponseBuilder.buildSuccess();
        } catch (Exception e) {
            logger.error("delete error:{}", e);
        }
        return ResponseBuilder.buildError();
    }

}
