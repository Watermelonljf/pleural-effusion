package org.bysj.pleural.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * <pre>类名: RoleSaveRequestDTO</pre>
 * <pre>描述: 角色保存请求DTO</pre>
 * <pre>日期: 2018/3/28  10:24</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleSaveRequestDTO {

    private String role;

    private String description;

    private List<Integer> resourceIds;

}
