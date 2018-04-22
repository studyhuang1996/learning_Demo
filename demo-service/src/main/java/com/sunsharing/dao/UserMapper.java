/*
 * @(#) IUserDao
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-17 14:22:55
 */

package com.sunsharing.dao;

import com.sunsharing.entity.User;

public interface UserMapper {

   User login(User user);

   int deleteByPrimaryKey(Integer id);

   int insert(User record);

   int insertSelective(User record);

   User selectByPrimaryKey(Integer id);

   int updateByPrimaryKeySelective(User record);

   int updateByPrimaryKey(User record);
}
