package com.demo.dao.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.BaseDao;
import com.demo.dao.GoodsInfoMapper;
import com.demo.entity.GoodsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("goodsInfoMapper")
public class GoodsInfoMapperImpl extends BaseDao implements GoodsInfoMapper {


    @Override
    public String getNamespace() {
        return "com.demo.dao.GoodsInfoMapper";
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sql.delete(getNamespace()+".deleteByPrimaryKey", id);
    }

    @Override
    public int insert(GoodsInfo record) {
        return sql.insert(getNamespace()+".insert", record);
    }

    @Override
    public int insertSelective(GoodsInfo record) {
        return sql.insert(getNamespace()+".insertSelective", record);
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Integer id) {
        return sql.selectOne(getNamespace()+".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKey", record);
    }

    @Override
    public Paginator page(Paginator paginator){
        return super.page("pageCount", "pageList", paginator);
    }

    @Override
    public List<GoodsInfo> selectListBySelective(GoodsInfo record) {
        return sql.selectList(getNamespace()+".selectListBySelective", record);
    }
}
