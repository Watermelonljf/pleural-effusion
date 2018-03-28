package org.bysj.pleural.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.bean.RoleResource;
import org.bysj.pleural.mapper.RoleResourceMapper;
import org.bysj.pleural.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>类名: RoleResourceServiceImpl</pre>
 * <pre>描述: 角色资源服务实现</pre>
 * <pre>日期: 2018/3/28  10:17</pre>
 * <pre>作者: ljianf</pre>
 */
@Service
@Slf4j
public class RoleResourceServiceImpl implements RoleResourceService{

    @Autowired
    private RoleResourceMapper roleResourceMapper;


    @Override
    public Integer saveRoleResources(List<RoleResource> list) {
      return roleResourceMapper.saveRoleResource(list);
    }
}
