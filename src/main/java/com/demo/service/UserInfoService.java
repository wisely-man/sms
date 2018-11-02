package com.demo.service;

import com.demo.entity.UserInfo;

import java.util.List;

public interface UserInfoService {


    UserInfo selectByPrimaryKey(Integer id);

    List<UserInfo> selectListBySelective(UserInfo userInfo);

}
