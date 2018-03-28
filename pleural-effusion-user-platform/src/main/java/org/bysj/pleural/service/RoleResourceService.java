package org.bysj.pleural.service;

import org.bysj.pleural.bean.RoleResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>类名: RoleResourceService</pre>
 * <pre>描述: 角色资源服务</pre>
 * <pre>日期: 2018/3/28  10:16</pre>
 * <pre>作者: ljianf</pre>
 */
public interface RoleResourceService {

    @Transactional
    Integer saveRoleResources(List<RoleResource> roleResources);
}
