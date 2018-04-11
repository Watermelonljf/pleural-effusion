package org.bysj.pleural.facade;

import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.MenuDTO;
import org.bysj.pleural.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resources;
import java.util.List;

/**
 * <pre>类名: ResourceFace</pre>
 * <pre>描述: 资源Facade</pre>
 * <pre>日期: 2018/3/22  16:33</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
public class ResourceFacade {

    @Autowired
    private ResourceService resourceService;
    /**
     * @Description: 获取用户资源
     * @date   2018/3/22 16:36
     * @param
     * @return
     * @author ljianf
     */
    public Response<List<MenuDTO>> getUserMenus(Integer userId){
        return Response.success(resourceService.getUserMenu(userId));
    }

    public Response<?> getAllMenu(){
        return Response.success(resourceService.getAllMenu());
    }
}
