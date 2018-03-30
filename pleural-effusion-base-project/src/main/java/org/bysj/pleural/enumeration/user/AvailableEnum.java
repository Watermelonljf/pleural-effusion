package org.bysj.pleural.enumeration.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>类名: AvailableEnum</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/30  10:21</pre>
 * <pre>作者: ljianf</pre>
 */
@AllArgsConstructor
public enum AvailableEnum {

    USER_NOT_AVAILABLE(1,"用户未激活！"),
    USER_AVAILABLED(2,"用户已激活");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String text;
}
