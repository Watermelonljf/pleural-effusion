package org.bysj.pleural.service;

import io.swagger.models.auth.In;
import org.bysj.pleural.bean.Resource;
import org.bysj.pleural.dto.user.MenuDTO;
import org.bysj.pleural.dto.user.ResourceDTO;

import java.util.List;

/**
 * <pre>类名: ResourceService</pre>
 * <pre>描述: 资源服务</pre>
 * <pre>日期: 2018/3/22  16:03</pre>
 * <pre>作者: ljianf</pre>
 */
public interface ResourceService {
    List<ResourceDTO> getUserResource(Integer userId);
    List<MenuDTO> getUserMenu(Integer userId);

    List<Resource> getAllMenu();
}
