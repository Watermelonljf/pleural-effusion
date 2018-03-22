package org.bysj.pleural.bean;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>类名: Resource</pre>
 * <pre>描述: 资源实体</pre>
 * <pre>日期: 2018/3/22  14:23</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    private Integer id;

    private String name;

    private String type;

    private String url;

    private Integer parentId;

    private Integer available;

    private Integer order;

    private Date createTime;

    private Date updateTime;
}
