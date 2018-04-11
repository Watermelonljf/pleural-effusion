package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bysj.pleural.bean.Resource;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.dto.user.ResourceDTO;

import java.util.List;

/**
 * <pre>类名: ResourceMapper</pre>
 * <pre>描述: 资源数据访问接口</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/22  14:27</pre>
 * <pre>作者: ljianf</pre>
 */
@Mapper
public interface ResourceMapper {

    public List<ResourceDTO> listUserResource(Integer userId);


    public List<Resource> getAllResource();
}
