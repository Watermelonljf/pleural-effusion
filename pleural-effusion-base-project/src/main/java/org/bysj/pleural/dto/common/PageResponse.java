package org.bysj.pleural.dto.common;

import org.bysj.pleural.enumeration.common.ResponseTypeEnum;

/**
 * className: PageResponse
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/8
 */
public class PageResponse<T> { //返回状态

    private Integer code;

    //消息
    private String  msg;

    private Integer count;

    private T data;

    public PageResponse(Integer code) {
        this.code = code;
    }

    public PageResponse(Integer code, Integer count, T data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public PageResponse(Integer code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public PageResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> PageResponse<T> success(){
        return new PageResponse(0);
    }


    public static <T> PageResponse<T> success(Integer count, T data){
        return new PageResponse(0,"",count,data);
    }

    public static <T> PageResponse<T> error(){
        return PageResponse.error(-1,null);
    }

    public static <T> PageResponse<T> error(Integer code,String msg){
        return new PageResponse(code,msg);
    }
}
