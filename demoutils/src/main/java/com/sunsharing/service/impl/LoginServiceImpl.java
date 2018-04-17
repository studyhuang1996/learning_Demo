/*
 * @(#) LoginServiceImpl
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-17 14:30:34
 */

package com.sunsharing.service.impl;

import com.sunsharing.api.ServerResponse;
import com.sunsharing.dao.IUserDao;
import com.sunsharing.entity.User;
import com.sunsharing.service.LoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
     private IUserDao userDao;

    @Override
    public ServerResponse<User> login(String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return null;
        }

       User user = userDao.login(userName,password);
        if (user == null){
            return ServerResponse.createErrorByMsg("账号或者密码错误");
        }
        return  ServerResponse.createSuccess("登录成功",user);
    }
}
