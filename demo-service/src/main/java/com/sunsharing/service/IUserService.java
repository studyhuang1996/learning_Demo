/*
 * @(#) LoginService
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-17 10:02:30
 */

package com.sunsharing.service;

import com.sunsharing.api.ServerResponse;
import com.sunsharing.entity.User;

public interface IUserService {

    User login(User user);

    /**
     * 保存更新
     * @param user
     * @return
     */
   ServerResponse<String> saveOrUpdate(User user);

   ServerResponse<User> getUserInfo(Integer id);

   ServerResponse<String> deleteUserById(Integer id);

}
