package org.bysj.pleural.service;

import org.bysj.pleural.bean.Role;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>类名: RoleService</pre>
 * <pre>描述: 角色服务</pre>
 * <pre>日期: 2018/3/28  10:13</pre>
 * <pre>作者: ljianf</pre>
 */
public interface RoleService {

    @Transactional
    Integer saveRole(Role role);
}
