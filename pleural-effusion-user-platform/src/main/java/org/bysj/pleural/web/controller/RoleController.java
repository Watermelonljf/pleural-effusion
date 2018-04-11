package org.bysj.pleural.web.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.bysj.pleural.bean.Role;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.bean.PackageList;
import org.bysj.pleural.dto.user.RoleSaveRequestDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.RoleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>类名: RoleController</pre>
 * <pre>描述: 角色控制器</pre>
 * <pre>日期: 2018/3/28  10:56</pre>
 * <pre>作者: ljianf</pre>
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleFacade roleFacade;


    @PostMapping(value = "/save")
    public Response<?> saveRoleInfo(RoleSaveRequestDTO request){
        if(StringUtils.isBlank(request.getRole())){
            throw new BusinessException(UserMessageConstant.ROLE_NAME_EMPTY);
        }
        List<Integer> resourceIds = JSON.parseArray(request.getResource(),Integer.class);
        return roleFacade.saveRoleInfo(request,resourceIds);
    }


    @GetMapping(value = "/getRoles")
    public PageResponse<?> queryRoles(@RequestParam(value = "pageIndex") Integer pageIndex,
                                      @RequestParam(value = "pageSize") Integer pageSize){

        return roleFacade.queryRoles(pageIndex, pageSize);
    }

    @PostMapping(value = "/update")
    public Response<?> updateRole(Role role){
        return roleFacade.updateRole(role);
    }

    @PostMapping(value = "/delete")
    public Response<?> deleteRole(@RequestParam(value = "id") Integer id){
        return roleFacade.deleteRole(id);
    }

    @PostMapping(value = "delete/batch")
    public Response<?> batche(String json){
        List<Integer> ids = JSON.parseArray(json, Integer.class);
        return roleFacade.batchDel(ids);
    }
}
