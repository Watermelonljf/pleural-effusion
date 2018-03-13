package org.bysj.pleural.dto.common;

/**
 * Http请求外层返回
 * Created by ljianf on 2017/7/27.
 */

public class Response<T> {

    //返回代码
    private Integer code;

    //请求的url
    private String  url;

    //消息
    private String  message;

    //数据
    private T data;

    public Response() {
    }

    public Response(Integer code, String url, String message, T data) {
        this.code = code;
        this.url = url;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
