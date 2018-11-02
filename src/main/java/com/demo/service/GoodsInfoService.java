package com.demo.service;

import com.demo.core.common.Paginator;
import com.demo.entity.GoodsInfo;

public interface GoodsInfoService {
    Paginator page(Paginator paginator);

    GoodsInfo selectById(Integer id);

    Integer save(GoodsInfo record);

    int delete(Integer id);
}
