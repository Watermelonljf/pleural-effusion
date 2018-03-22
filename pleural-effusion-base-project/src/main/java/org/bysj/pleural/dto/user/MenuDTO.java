package org.bysj.pleural.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>类名: MenuDTO</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/22  16:07</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@NoArgsConstructor
public class MenuDTO {

    private Integer resourceId;

    private String name;

    private String icon;

    private Integer order;

    private List<ResourceDTO> resources = new ArrayList<>();
}
