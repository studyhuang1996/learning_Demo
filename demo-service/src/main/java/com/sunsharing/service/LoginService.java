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

public interface LoginService {

    User login(User user);
}
