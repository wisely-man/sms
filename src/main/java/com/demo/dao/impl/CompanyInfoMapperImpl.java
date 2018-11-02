package com.demo.dao.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.BaseDao;
import com.demo.dao.CompanyInfoMapper;
import com.demo.entity.CompanyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("companyInfoMapper")
public class CompanyInfoMapperImpl extends BaseDao implements CompanyInfoMapper {

    @Override
    public String getNamespace() {
        return "com.demo.dao.CompanyInfoMapper";
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sql.delete(getNamespace()+".deleteByPrimaryKey", id);
    }

    @Override
    public int insert(CompanyInfo record) {
        return sql.insert(getNamespace()+".insert", record);
    }

    @Override
    public int insertSelective(CompanyInfo record) {
        return sql.insert(getNamespace()+".insertSelective", record);
    }

    @Override
    public CompanyInfo selectByPrimaryKey(Integer id) {
        return sql.selectOne(getNamespace()+".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(CompanyInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKey", record);
    }

    @Override
    public List<CompanyInfo> selectListBySelective(CompanyInfo record){
        return sql.selectList(getNamespace()+".selectListBySelective", record);
    }

    @Override
    public Paginator page(Paginator paginator){
        return super.page("pageCount", "pageList", paginator);
    }
}
