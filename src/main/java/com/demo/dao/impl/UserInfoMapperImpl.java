package com.demo.dao.impl;

import com.demo.dao.BaseDao;
import com.demo.dao.UserInfoMapper;
import com.demo.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoMapper")
public class UserInfoMapperImpl extends BaseDao implements UserInfoMapper {


    @Override
    public String getNamespace() {
        return "com.demo.dao.UserInfoMapper";
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sql.delete(getNamespace()+".deleteByPrimaryKey", id);
    }

    @Override
    public int insert(UserInfo record) {
        return sql.insert(getNamespace()+".insert", record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return sql.insert(getNamespace()+".insertSelective", record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return sql.selectOne(getNamespace()+".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return sql.update(getNamespace()+".updateByPrimaryKey", record);
    }

    @Override
    public List<UserInfo> selectListBySelective(UserInfo record){
        return sql.selectList(getNamespace()+".selectListBySelective", record);
    }
}
