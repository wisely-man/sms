package com.demo.service;

import com.demo.core.common.Paginator;
import com.demo.entity.CompanyInfo;
import com.demo.entity.GoodsInfo;
import com.demo.entity.SalesTurnover;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SalesTurnoverService {

    Paginator page(Paginator paginator);

    SalesTurnover selectById(Integer id);

    Integer save(HttpServletRequest request, SalesTurnover record);

    int delete(Integer id);

    List<CompanyInfo> getAllCompanyList();

    List<GoodsInfo> getAllGoodsList();
}
