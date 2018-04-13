package org.bysj.pleural.enumeration.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>类名: LockedStateEnum</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/14  10:04</pre>
 * <pre>作者: ljianf</pre>
 */

@AllArgsConstructor
public enum LockedStateEnum {

    USER_LOCKED("YES","用户已锁定"),
    USER_NOT_lOCKED("NO","用户为锁定");

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String text;


}
