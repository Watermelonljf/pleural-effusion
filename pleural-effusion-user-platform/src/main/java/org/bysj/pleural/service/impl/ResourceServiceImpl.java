package org.bysj.pleural.service.impl;

import org.bysj.pleural.bean.Resource;
import org.bysj.pleural.dto.user.MenuDTO;
import org.bysj.pleural.dto.user.ResourceDTO;
import org.bysj.pleural.mapper.ResourceMapper;
import org.bysj.pleural.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>类名: ResourceServiceImpl</pre>
 * <pre>描述: 资源服务实现</pre>
 * <pre>日期: 2018/3/22  16:04</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<MenuDTO> getUserMenu(Integer userId) {
        List<ResourceDTO> resources = resourceMapper.listUserResource(userId);
        List<MenuDTO> menus = new ArrayList<>();
        resources.forEach(resource->{
            if(resource.getParentId()<0){
                MenuDTO menu = new MenuDTO();
                menu.setOrder(resource.getOrder());
                menu.setName(resource.getName());
                menu.setIcon(resource.getIcon());
                menu.setResourceId(resource.getResourceId());
                menus.add(menu);
            }
        });
        for(int i = 0 ;i<menus.size();i++){
            MenuDTO parentMenu = menus.get(i);
            for(int j=0;j<resources.size();j++){
                ResourceDTO res = resources.get(j);
                if(res.getParentId()==parentMenu.getResourceId()){
                    parentMenu.getResources().add(res);
                }
            }
        }
        return menus;
    }

    @Override
    public List<Resource> getAllMenu() {
        return resourceMapper.getAllResource();
    }
}
