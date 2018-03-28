package org.bysj.pleural.facade;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bysj.pleural.bean.Role;
import org.bysj.pleural.bean.RoleResource;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.RoleSaveRequestDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.service.RoleResourceService;
import org.bysj.pleural.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>类名: RoleFacade</pre>
 * <pre>描述: 角色Facade</pre>
 * <pre>日期: 2018/3/28  10:19</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
@Slf4j
public class RoleFacade {


    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleResourceService roleResourceService;

    /**
     * @Description: 保存角色信息
     * @date   2018/3/28 10:27
     * @param
     * @return
     * @author ljianf
     */
    public Response<?> saveRoleInfo(RoleSaveRequestDTO request){
        //保存role
        Role role = new Role();
        BeanUtils.copyProperties(request,role,Role.class);
        roleService.saveRole(role);
        //保存对应的资源信息
        List<RoleResource> roleResourceList= new ArrayList<>();
        request.getResourceIds().forEach(resourceId->{
            RoleResource roleResource = new RoleResource();
            roleResource.setResourceId(resourceId);
            roleResource.setRoleId(role.getId());
            roleResourceList.add(roleResource);
        });
        roleResourceService.saveRoleResources(roleResourceList);
        return Response.success();
    }

}
