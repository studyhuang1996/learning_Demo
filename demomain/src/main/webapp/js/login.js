/*
 * @(#) login.js
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
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

