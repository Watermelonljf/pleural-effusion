package org.bysj.pleural.web.controller;

import lombok.Getter;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.MenuDTO;
import org.bysj.pleural.facade.ResourceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>类名: ResourceController</pre>
 * <pre>描述: 资源控制器</pre>
 * <pre>日期: 2018/3/22  16:37</pre>
 * <pre>作者: ljianf</pre>
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceController {

    @Autowired
    private ResourceFacade resourceFacade;

    @GetMapping(value = "/user/menu")
    public Response<List<MenuDTO>> getUserMenu(@RequestParam("userId") Integer userId){
        return resourceFacade.getUserMenus(userId);
    }

    @GetMapping(value = "/list/all")
    public Response<?> getAllMenu(){
        return resourceFacade.getAllMenu();
    }

    @GetMapping("/list/notGrant")
    public Response<?> getNotGrantResource( @RequestParam("roleId") Integer roleId){
        return resourceFacade.getUserNotGrantResource(roleId);
    }

    @GetMapping("/list/grantedResult")
    public Response<?> getGrantedResource(@RequestParam("roleId") Integer roleId){
        return resourceFacade.getGrantedResource(roleId);
    }


    @GetMapping("/list/roleResources")
    public PageResponse<?> listResourceByRoleId(@RequestParam("roleId") Integer roleId){

        return PageResponse.success(null,resourceFacade.getGrantedResource(roleId).getData());
    }



}
