package org.bysj.pleural.enumeration.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>类名: RoleEnum</pre>
 * <pre>描述: 角色枚举</pre>
 * <pre>日期: 2018/3/30  16:46</pre>
 * <pre>作者: ljianf</pre>
 */
@AllArgsConstructor
public enum RoleEnum {
    ASUPER_ADMINISTRATOR (1,"超级管理员"),
    COMMON_ADMINISTRATOR(2,"管理员"),
    COMMON_USER(3,"普通用户");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String text;

}
