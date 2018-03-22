package org.bysj.pleural.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>类名: ResourceDTO</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/22  14:22</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class ResourceDTO {

    private Integer resourceId;

    private String name;

    private String url;

    private Integer parentId;

    private String icon;

    private Integer order;

}
