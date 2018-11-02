package com.demo.service.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.CompanyInfoMapper;
import com.demo.entity.CompanyInfo;
import com.demo.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoMapper companyInfoMapper;


    @Override
    public Paginator page(Paginator paginator){
        return companyInfoMapper.page(paginator);
    }

    @Override
    public List<CompanyInfo> selectListBySelective(CompanyInfo query) {
        return companyInfoMapper.selectListBySelective(query);
    }

    @Override
    public CompanyInfo selectById(Integer id) {
        return companyInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(CompanyInfo record) {
        return companyInfoMapper.insert(record);
    }

    @Override
    public int updateBySelective(CompanyInfo record) {
        return companyInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Integer id) {
        return companyInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer save(CompanyInfo record) {
        Integer id = record.getId();
        if(id == null){
            this.insert(record);
        } else {
            this.updateBySelective(record);
        }
        return id;
    }
}
