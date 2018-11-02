package com.demo.service.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.GoodsInfoMapper;
import com.demo.entity.GoodsInfo;
import com.demo.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public Paginator page(Paginator paginator){
        return goodsInfoMapper.page(paginator);
    }

    @Override
    public GoodsInfo selectById(Integer id){
        return goodsInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer save(GoodsInfo record){

        Integer id = record.getId();
        if(id == null){
            goodsInfoMapper.insert(record);
        }else{
            goodsInfoMapper.updateByPrimaryKeySelective(record);
        }
        return id;
    }

    @Override
    public int delete(Integer id){
        return goodsInfoMapper.deleteByPrimaryKey(id);
    }
}
