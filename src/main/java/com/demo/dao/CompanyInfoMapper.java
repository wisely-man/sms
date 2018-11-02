package com.demo.dao;

import com.demo.core.common.Paginator;
import com.demo.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);

    List<CompanyInfo> selectListBySelective(CompanyInfo record);

    Paginator page(Paginator paginator);
}