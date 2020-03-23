package com.wangzhe.dianping.service.impl;

import com.wangzhe.dianping.dal.UserModelMapper;
import com.wangzhe.dianping.model.UserModel;
import com.wangzhe.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 19:23
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }
}
