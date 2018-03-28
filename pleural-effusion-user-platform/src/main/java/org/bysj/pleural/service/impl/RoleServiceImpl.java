package org.bysj.pleural.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.bean.Role;
import org.bysj.pleural.mapper.RoleMapper;
import org.bysj.pleural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>类名: RoleServiceImpl</pre>
 * <pre>描述: 角色服务实现</pre>
 * <pre>日期: 2018/3/28  10:14</pre>
 * <pre>作者: ljianf</pre>
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer saveRole(Role role) {
        return roleMapper.saveRole(role);
    }
}
