package org.bysj.pleural.bean;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>类名: Role</pre>
 * <pre>描述: 角色实体</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/13  13:20</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = -3366346518822005553L;

    private Integer id;

    private String role;

    private String description;

    private Integer available;

    private Date createTime;

    private Date updateTime;

}
