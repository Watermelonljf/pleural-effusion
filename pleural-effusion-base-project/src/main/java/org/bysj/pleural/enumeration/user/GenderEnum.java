package org.bysj.pleural.enumeration.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>类名: Gender</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/30  16:51</pre>
 * <pre>作者: ljianf</pre>
 */
@AllArgsConstructor
public enum GenderEnum {

    GENDER_MAN(0,"男"),
    GENDER_WOMEN(1,"女");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String text;

}
