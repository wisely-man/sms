package com.demo.dao.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.BaseDao;
import com.demo.dao.SalesTurnoverMapper;
import com.demo.entity.SalesTurnover;
import org.springframework.stereotype.Repository;

@Repository("salesTurnoverMapper")
public class SalesTurnoverMapperImpl extends BaseDao implements SalesTurnoverMapper {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sql.delete(getNamespace()+".deleteByPrimaryKey", id);
    }

    @Override
    public int insert(SalesTurnover record) {
        return sql.insert(getNamespace()+".insert", record);
    }

    @Override
    public int insertSelective(SalesTurnover record) {
        return sql.insert(getNamespace()+".insertSelective", record);
    }

    @Override
    public SalesTurnover selectByPrimaryKey(Integer id) {
        return sql.selectOne(getNamespace()+".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(SalesTurnover record) {
        return sql.insert(getNamespace()+".updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(SalesTurnover record) {
        return sql.insert(getNamespace()+".updateByPrimaryKey", record);
    }

    @Override
    public String getNamespace() {
        return "com.demo.dao.SalesTurnoverMapper";
    }

    @Override
    public Paginator page(Paginator paginator){
        return super.page("pageCount", "pageList", paginator);
    }
}
