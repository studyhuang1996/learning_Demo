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
    import com.sunsharing.dao.UserMapper;
import com.sunsharing.entity.User;
import com.sunsharing.service.LoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
     private UserMapper userDao;

    @Override
    public User login(User user) {
       User user1 = userDao.login(user);
        return user1;
    }
}
