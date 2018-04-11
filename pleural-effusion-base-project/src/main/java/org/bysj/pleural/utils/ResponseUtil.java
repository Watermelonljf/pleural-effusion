package org.bysj.pleural.utils;

import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.enumeration.common.ResponseTypeEnum;

/**
 * className: ResponseUtil
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/6
 */
public class ResponseUtil {
    /**
     * 有结果数据的成功返回
     *
     * @param object
     * @return
     */
    public static Response success(Object object){
        Response result = new Response();
        result.setType(ResponseTypeEnum.SUCCESS);
        result.setData(object);
        return result;
    }

    /**
     *
     * 错误返回
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static Response error(String msg){
        Response result = new Response();
        result.setMessage(msg);
        return result;
    }


}
