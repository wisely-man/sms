package com.demo.dao;

import com.demo.core.common.Paginator;
import com.demo.entity.SalesTurnover;

public interface SalesTurnoverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesTurnover record);

    int insertSelective(SalesTurnover record);

    SalesTurnover selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesTurnover record);

    int updateByPrimaryKey(SalesTurnover record);

    Paginator page(Paginator paginator);
}