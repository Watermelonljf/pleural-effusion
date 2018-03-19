package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bysj.pleural.bean.User;

import java.util.List;

/**
 * <pre>类名: UserMapper</pre>
 * <pre>描述: 用户数据访问Mapper</pre>
 * <pre>日期: 2018/3/13  13:52</pre>
 * <pre>作者: ljianf</pre>
 */
@Mapper
public interface UserMapper{

    public void saveUser(User user);

    public User findUserByUsername(@Param("username") String username);

    public Integer changePasswordByUsername(@Param("username") String username,@Param("password") String password);
    public int updateUser(User user);

    public User findById();

    public List<User> listUsers();

}
