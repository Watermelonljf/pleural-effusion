package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bysj.pleural.bean.Role;

/**
 * <pre>类名: RoleMapper</pre>
 * <pre>描述: 角色数据访问接口</pre>
 * <pre>日期: 2018/3/21  17:13</pre>
 * <pre>作者: ljianf</pre>
 */
@Mapper
public interface RoleMapper {

    /**
     * @Description: 保存角色信息
     * @date   2018/3/21 19:01
     * @param role
     * @return 成功记录数
     * @author ljianf
     */
    Integer saveRole(Role role);
}
