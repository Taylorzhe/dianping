package com.wangzhe.dianping.service;

import com.wangzhe.dianping.common.BusinessException;
import com.wangzhe.dianping.model.UserModel;

import java.security.NoSuchAlgorithmException;

/**
 * @author： Wang Zhe
 * @date： 2020/3/23 19:16
 * @description： 有关用户操作方法的接口
 * @modifiedBy：
 * @version: 1.0
 */
public interface UserService {

    UserModel getUser(Integer id);

    UserModel register(UserModel registerUser) throws BusinessException, NoSuchAlgorithmException;

    UserModel login(String telephone, String password) throws NoSuchAlgorithmException, BusinessException;

    Integer countAllUser();
}
