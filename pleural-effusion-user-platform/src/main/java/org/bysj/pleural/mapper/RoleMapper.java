package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bysj.pleural.bean.Role;

import java.util.List;

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


    /**
     * @Description: 根据id删除角色
     * @date   2018/3/22 9:19
     * @param
     * @return
     * @author ljianf
     */
    Integer deleteById();

    /**
     * @Description: 分页查询角色数据
     * @date   2018/3/22 9:18
     * @param
     * @return
     * @author ljianf
     */
    List<Role> listRolesPage();
}
