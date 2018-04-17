/*
 * @(#) UserController
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-17 11:34:42
 */

package com.sunsharing.controller;


import com.sunsharing.api.ServerResponse;
import com.sunsharing.entity.User;
import com.sunsharing.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @RequestMapping("login")
    @ResponseBody
    public ServerResponse<User>  login(String username,String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
          return  ServerResponse.createErrorByMsg("参数为空");

        }
        ServerResponse<User> serverResponse = loginService.login(username, password);
        return serverResponse;
    }

}
