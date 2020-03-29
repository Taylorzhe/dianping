package com.wangzhe.dianping.service.impl;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.common.EmTrueError;
import com.wangzhe.dianping.dal.UserModelMapper;
import com.wangzhe.dianping.model.UserModel;
import com.wangzhe.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 19:23
 * @description： 有关用户操作方法的实现
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

    @Override
    @Transactional
    public UserModel register(UserModel registerUser) throws BusinessException, NoSuchAlgorithmException {
        registerUser.setPassword(encodeByMD5(registerUser.getPassword()));
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());

        try {
            userModelMapper.insertSelective(registerUser);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmTrueError.REGISTER_DUP_FAIL);
        }
        return getUser(registerUser.getId());
    }

    @Override
    public UserModel login(String telephone, String password) throws NoSuchAlgorithmException, BusinessException {
        UserModel userModel = userModelMapper.selectByTelephoneAndPassword(telephone, encodeByMD5(password));
        if (userModel == null){
            throw new BusinessException(EmTrueError.LOGIN_FAIL);
        }
        return userModel;
    }

    @Override
    public Integer amountOfUsers() {
        return userModelMapper.amountOfUsers();
    }

    private String encodeByMD5(String str) throws NoSuchAlgorithmException {
        //确认计算方法MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}
