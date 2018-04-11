package org.bysj.pleural.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>类名: RoleDTO</pre>
 * <pre>描述: 角色DTO</pre>
 * <pre>日期: 2018/3/21  17:11</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class RoleDTO {
    private String role;

    private String description;

    private String resources;

    private List<ResourceDTO> resourceDTOS = new ArrayList<>();

    private Integer available;

    private Date createTime;

    private Date updateTime;
}
