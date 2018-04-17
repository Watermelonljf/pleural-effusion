package org.bysj.pleural.enumeration.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>类名: ResponseTypeEnum</pre>
 * <pre>描述: 返回状态</pre>
 * <pre>日期: 2018/3/19  13:41</pre>
 * <pre>作者: ljianf</pre>
 */
@AllArgsConstructor
public enum  ResponseTypeEnum {

    SUCCESS("SUCCESS","01"),
    ERROE("ERROR","02"),
    EXPIRED("EXPIRED","03");
    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private String code;


}
