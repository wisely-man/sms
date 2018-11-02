package com.demo.service;

import com.demo.core.common.Paginator;
import com.demo.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {


    Paginator page(Paginator paginator);

    List<CompanyInfo> selectListBySelective(CompanyInfo query);

    CompanyInfo selectById(Integer id);

    int insert(CompanyInfo record);

    int updateBySelective(CompanyInfo record);

    int delete(Integer id);

    Integer save(CompanyInfo record);
}
