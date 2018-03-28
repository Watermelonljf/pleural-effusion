package org.bysj.pleural.bean;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>类名: RoleResource</pre>
 * <pre>描述: 角色资源实体</pre>
 * <pre>日期: 2018/3/28  10:05</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleResource {

    private Integer roleId;

    private Integer resourceId;
}
