/*
 * @(#) ServerResponse
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-17 14:38:01
 */

package com.sunsharing.api;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by huang on 2018/3/16.
 */
//字段为空，不显示 ,数据为空，key也不显示
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private  int status;
    private  String msg;
    private  T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(String msg,T data) {
        this.data = data;
        this.msg = msg;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    //不返回给前端
    @JsonIgnore
    public boolean isSuccess(){
        return  this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
  //为何用static方法写入，而不用set方法
    //<T>代表泛型，没有第一个<T>代表T是一个类
    public  static <T> ServerResponse<T> createSuccess(){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public  static <T> ServerResponse<T> createSuccessByMsg(String msg){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public  static <T> ServerResponse<T> createSuccess(T data){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public  static <T> ServerResponse<T> createSuccess(String msg,T data){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public  static <T> ServerResponse<T> createError(){
        return  new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public  static <T> ServerResponse<T> createErrorByMsg(String msg){
        return  new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }
    public  static <T> ServerResponse<T> createError(int errorCode,String msg){
        return  new ServerResponse<T>(errorCode,msg);
    }

}
