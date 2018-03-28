package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bysj.pleural.bean.RoleResource;

import java.util.List;

/**
 * <pre>类名: RoleResourceMapper</pre>
 * <pre>描述: 角色资源数据访问接口</pre>
 * <pre>日期: 2018/3/28  10:06</pre>
 * <pre>作者: ljianf</pre>
 */
@Mapper
public interface RoleResourceMapper {


    Integer saveRoleResource(List<RoleResource> list);
}
