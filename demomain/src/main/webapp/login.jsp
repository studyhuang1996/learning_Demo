<%--
  ~ @(#) login.jsp
  ~ 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
  ~
  ~ <br> Copyright:  Copyright (c) 2018
  ~ <br> Company:厦门畅享信息技术有限公司
  ~ <br> @author huang
  ~ <br> 2018-04-17 16:28:05
  --%>

<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <%--<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>--%>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="login-box">
        <div class="login-title">
            <a>login</a>
        </div>
        <div class="login-input">
            <p>
                <a >username:</a>
                <input type="text" name="username"  id="username" value="">
            </p>
            <p>
                <a >password:</a>
                <input type="password" name="password" id="password" value="">
            </p>

        </div>
        <div class="login-btn">
            <input type="button" name="login" value="login" id="login">
        </div>
    </div>
</div>
</body>
</html>