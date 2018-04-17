package org.bysj.pleural.dto.common;

import org.bysj.pleural.enumeration.common.ResponseTypeEnum;

/**
 * Http请求外层返回
 * Created by ljianf on 2017/7/27.
 */

public class Response<T> {

    //返回状态
    private ResponseTypeEnum  type;

    //请求的url
    private String  url;

    //消息
    private String  message;

    //数据
    private T data;

    public Response() {
    }

    public Response(ResponseTypeEnum type, String url, String message, T data) {
        this.type = type;
        this.url = url;
        this.message = message;
        this.data = data;
    }

    /**
     * 获取type
     * return type
     **/
    public ResponseTypeEnum getType() {
        return type;
    }

    /**
     * 获取type
     *
     * @param type
     **/
    public void setType(ResponseTypeEnum type) {
        this.type = type;
    }

    /**
     * 获取url
     * return url
     **/
    public String getUrl() {
        return url;
    }

    /**
     * 获取url
     *
     * @param url
     **/
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取message
     * return message
     **/
    public String getMessage() {
        return message;
    }

    /**
     * 获取message
     *
     * @param message
     **/
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取data
     * return data
     **/
    public T getData() {
        return data;
    }

    /**
     * 获取data
     *
     * @param data
     **/
    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(){
        return new Response(ResponseTypeEnum.SUCCESS,"","","");
    }

    public static <T> Response<T> success(T data){
        return new Response(ResponseTypeEnum.SUCCESS,"","",data);
    }

    public static <T> Response<T> success(String message,T data){
        return new Response(ResponseTypeEnum.SUCCESS,null,message,data);
    }

    public static <T> Response<T> error(){
        return new Response(ResponseTypeEnum.ERROE,null,null,null);
    }

    public static <T> Response<T> error(String message){
        return new Response(ResponseTypeEnum.ERROE,"",message,null);
    }
    public static <T> Response<T> expired(String message){
        return new Response(ResponseTypeEnum.EXPIRED,"",message,null);
    }
    public static <T> Response<T> expired(){
        return new Response(ResponseTypeEnum.EXPIRED,"",null,null);
    }
}
