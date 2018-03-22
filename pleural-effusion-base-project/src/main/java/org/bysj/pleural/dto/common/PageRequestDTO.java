package org.bysj.pleural.dto.common;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>类名: PageRequestDTO</pre>
 * <pre>描述: 通用分页请求参数</pre>
 * <pre>日期: 2018/3/22  9:21</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageRequestDTO {

    private Integer pageIndex;  //当前页码

    private Integer pageSize;   //当前页大小
}
