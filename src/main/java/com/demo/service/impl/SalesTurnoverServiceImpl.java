package com.demo.service.impl;

import com.demo.core.common.Paginator;
import com.demo.dao.CompanyInfoMapper;
import com.demo.dao.GoodsInfoMapper;
import com.demo.dao.SalesTurnoverMapper;
import com.demo.entity.CompanyInfo;
import com.demo.entity.GoodsInfo;
import com.demo.entity.SalesTurnover;
import com.demo.entity.UserInfo;
import com.demo.service.SalesTurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SalesTurnoverServiceImpl implements SalesTurnoverService {


    @Autowired
    private SalesTurnoverMapper salesTurnoverMapper;
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;


    @Override
    public Paginator page(Paginator paginator){
        return salesTurnoverMapper.page(paginator);
    }


    @Override
    public SalesTurnover selectById(Integer id) {
        return salesTurnoverMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer save(HttpServletRequest request, SalesTurnover record) {
        Integer id = record.getId();
        if(id == null){
            UserInfo currentUser = (UserInfo) request.getSession().getAttribute("userInfo");
            record.setOptId(currentUser.getId());
            record.setOptTime(new Date());
            salesTurnoverMapper.insert(record);
        }else{
            salesTurnoverMapper.updateByPrimaryKeySelective(record);
        }
        return id;
    }

    @Override
    public int delete(Integer id) {
        return salesTurnoverMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CompanyInfo> getAllCompanyList() {
        return companyInfoMapper.selectListBySelective(new CompanyInfo());
    }

    @Override
    public List<GoodsInfo> getAllGoodsList() {
        return goodsInfoMapper.selectListBySelective(new GoodsInfo());
    }
}
