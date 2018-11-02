package com.demo.service.impl;

import com.demo.dao.UserInfoMapper;
import com.demo.entity.UserInfo;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> selectListBySelective(UserInfo userInfo) {
        return userInfoMapper.selectListBySelective(userInfo);
    }

}
