/*
 * @(#) login.js
 *
 *登录页面 ajax请求数据
 * <br> Copyright:  Copyright (c) 2018
 * <br> @author huang
 * <br> 2018-04-17 16:37:33
 */
$(function () {
    $('#login').click(function(){
        $.post("http://localhost:8080/user/login.do",
               {
                   username:$('#username').val(),
                   password:$('#password').val()
               },
               function(data){
                 if (data.status == 0){

                     alert("数据: \n" + data.data.username + "\n状态: " + data.msg);
                 }else {
                     alert(data.msg)
                 }
               });
    });
});

