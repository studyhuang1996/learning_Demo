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
import com.sunsharing.service.IUserService;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
     private UserMapper userDao;

    @Override
    public User login(User user) {
       User user1 = userDao.login(user);
        return user1;
    }


    @Override
    public ServerResponse<String> saveOrUpdate(User user) {
        if (user.getId() ==null){
            int row = userDao.insert(user);
            if (row==0){
                return ServerResponse.createErrorByMsg("保存失败");
            }
            return  ServerResponse.createSuccessByMsg("保存成功");
        }
        int row = userDao.updateByPrimaryKey(user);
        if (row==0){
            return ServerResponse.createErrorByMsg("更新失败");
        }
        return  ServerResponse.createSuccessByMsg("更新成功");
    }

    @Override
    public ServerResponse<User> getUserInfo(Integer id) {
      User user = userDao.selectByPrimaryKey(id);
      if ( null == user){
          return ServerResponse.createSuccessByMsg("没有该用户");
      }
        return ServerResponse.createSuccess("获取个人用户信息成功",user);
    }

    @Override
    public ServerResponse<String> deleteUserById(Integer id) {

        int row = userDao.deleteByPrimaryKey(id);
        if (row==0){
            return ServerResponse.createErrorByMsg("删除失败");
        }
        return  ServerResponse.createSuccessByMsg("删除成功");
    }
}
