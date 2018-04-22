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
import com.sunsharing.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ServerResponse<User>  login(User user,HttpSession session){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
          return  ServerResponse.createErrorByMsg("参数为空");

        }
        User user1 = userService.login(user);

        if (user1 == null){
            return  ServerResponse.createErrorByMsg("账号或者密码错误");
        }
        session.setAttribute("user",user1);
        System.out.println(user1.toString());
        return ServerResponse.createSuccess("成功",user1);
    }


    /**
     * 增加更新
     */
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse<String> insertUser(User user,HttpSession session){
       User user1= (User) session.getAttribute("user");
       if (null ==user1){
           return ServerResponse.createErrorByMsg("用户未登录");
       }
         if (null == user){
             return ServerResponse.createSuccessByMsg("请输入用户信息");
         }

        return   userService.saveOrUpdate(user);
    }

    /**
     * 获取个人信息
     * @param id
     * @return
     */
    @RequestMapping("getInfo/{id}")
    @ResponseBody
    public ServerResponse<User> getUserInfo(@PathVariable Integer id,HttpSession session){
        User user1= (User) session.getAttribute("user");
        if (null ==user1){
            return ServerResponse.createErrorByMsg("用户未登录");
        }
        if (id == null){
            return  ServerResponse.createErrorByMsg("参数为空");
        }

        return null;
    }

    /**
     * 删除个人信息
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public ServerResponse<String> deleteUserById(@PathVariable Integer id,HttpSession session){
        User user1= (User) session.getAttribute("user");
        if (null ==user1){
            return ServerResponse.createErrorByMsg("用户未登录");
        }
        if (id == null){
            return  ServerResponse.createErrorByMsg("参数为空");
        }

        return userService.deleteUserById(id);
    }




}
