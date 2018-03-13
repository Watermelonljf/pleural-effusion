package org.bysj.pleural.exception;

/**
 * className: BusinessException
 * describe: 业务处理异常
 * author: Watermelon_R
 * date:   2017/12/24
 */
public class BusinessException extends RuntimeException{

    private String errorInfo;

    public BusinessException(String message) {
        super(message);
    }
}
