package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Param;
import org.bysj.pleural.bean.User;
import org.springframework.stereotype.Repository;

/**
 * <pre>类名: UserMapper</pre>
 * <pre>描述: 用户数据访问Mapper</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/13  13:52</pre>
 * <pre>作者: ljianf</pre>
 */
@Repository
public interface UserMapper{

    public void saveUser(User user);

    public User findUserByUsername(@Param("username") String username);

    public int updateUser(User user);

}
