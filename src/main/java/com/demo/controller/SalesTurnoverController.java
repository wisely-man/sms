package com.demo.controller;


import com.demo.core.common.FileUtils;
import com.demo.core.common.Paginator;
import com.demo.core.common.ResponseBuilder;
import com.demo.core.common.SpringApp;
import com.demo.entity.CompanyInfo;
import com.demo.entity.GoodsInfo;
import com.demo.entity.SalesTurnover;
import com.demo.entity.UserInfo;
import com.demo.enu.CategoryEnum;
import com.demo.enu.OptTypeEnum;
import com.demo.service.SalesTurnoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/turnover")
public class SalesTurnoverController {


    private final static Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);

    @Autowired
    private SalesTurnoverService salesTurnoverService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Paginator paginator, SalesTurnover record){

        try {

            paginator.setItemsPerPage(10);
            paginator.setParams(record);

            paginator = salesTurnoverService.page(paginator);
            request.setAttribute("turnoverList", paginator.getResults());

            request.setAttribute("paginator", paginator);
            request.setAttribute("categoryMap", CategoryEnum.getMap());
            request.setAttribute("optTypeMap", OptTypeEnum.getMap());

        } catch (Exception e) {
            logger.error("index error:{}", e);
        }
        return "turnover/turnover_index";
    }

    @RequestMapping("/toAdd")
    public String detail(HttpServletRequest request){

        request.setAttribute("optTypeMap", OptTypeEnum.getMap());
        request.setAttribute("companyList", salesTurnoverService.getAllCompanyList());
        request.setAttribute("goodsList", salesTurnoverService.getAllGoodsList());

        return "turnover/turnover_detail";
    }

    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Integer id){
        try {

            request.setAttribute("optTypeMap", OptTypeEnum.getMap());
            request.setAttribute("companyList", salesTurnoverService.getAllCompanyList());
            request.setAttribute("goodsList", salesTurnoverService.getAllGoodsList());

            request.setAttribute("record", salesTurnoverService.selectById(id));

        } catch (Exception e) {
            logger.error("detail error:{}", e);
        }
        return "turnover/turnover_detail";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(HttpServletRequest request, SalesTurnover record){
        try {

            salesTurnoverService.save(request, record);

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

            salesTurnoverService.delete(id);

            return ResponseBuilder.buildSuccess();
        } catch (Exception e) {
            logger.error("delete error:{}", e);
        }
        return ResponseBuilder.buildError();
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response, SalesTurnover record){
        try {

            Paginator paginator = new Paginator();
            paginator.setItemsPerPage(Integer.MAX_VALUE);
            paginator.setParams(record);
            paginator = salesTurnoverService.page(paginator);

            // 报表数据
            Map<String, Object> dataMap = new HashMap<>();
            // 文件路径
            dataMap.put("filePath", SpringApp.getServletContextPath()+"/sales_turnover_"
                    + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".xls");

            // 表单名
            dataMap.put("sheetName", "销售流水");
            // 标题部分
            List<List<String>> dataTitle = new ArrayList<List<String>>();
            List<String> title = new ArrayList<String>();
            title.add("流水编号");
            title.add("商品品类");
            title.add("商品名称");
            title.add("供应商名称");
            title.add("数量");
            title.add("操作类型");
            title.add("操作人");
            title.add("操作时间");
            dataTitle.add(title);
            dataMap.put("dataTitle", dataTitle);
            // 数据部分

            Map<String, String> categoryMap = CategoryEnum.getMap();
            Map<String, String> optTypeMap = OptTypeEnum.getMap();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            List<List<String>> dataBody = new ArrayList<>();
            List<String> body;
            for (SalesTurnover entity : (List<SalesTurnover>) paginator.getResults()) {
                body = new ArrayList<>();

                body.add(String.valueOf(entity.getId()));
                // 商品信息
                GoodsInfo goodsInfo = entity.getGoods();
                body.add(goodsInfo==null ? "" : categoryMap.get(goodsInfo.getCategory()));
                body.add(entity.getGoodsName());
                // 供应商信息
                body.add(entity.getCompanyName());

                body.add(entity.getGoodsNum().toString());
                body.add(optTypeMap.get(entity.getOptType()));

                // 操作人信息
                UserInfo userInfo = entity.getOperator();
                body.add(userInfo==null ? "" : userInfo.getUserName());

                body.add(df.format(entity.getOptTime()));

                dataBody.add(body);
            }
            dataMap.put("dataBody", dataBody);
            // 报表导出
            String filePath = FileUtils.exportExcel(dataMap);
            // 获取文件
            File file = new File(filePath);
            // 取得文件名
            String filename = file.getName();
            // 以流的形式下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream;charset=UTF-8");
            OutputStream output = response.getOutputStream();
            output.write(buffer);
            output.flush();

        } catch (Exception e) {
            logger.error("export error:{}", e);
        }
    }

}
