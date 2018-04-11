package org.bysj.pleural.handler;

import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一异常处理类
 * Created by Watermelon_R on 2017/7/2.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    //value可以是数组
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response handler(BusinessException e) {
        return ResponseUtil.error(e.getMessage());
    }
}
