package com.demo.dao;

import com.demo.core.common.Paginator;
import com.demo.entity.GoodsInfo;

import java.util.List;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    Paginator page(Paginator paginator);

    List<GoodsInfo> selectListBySelective(GoodsInfo record);
}