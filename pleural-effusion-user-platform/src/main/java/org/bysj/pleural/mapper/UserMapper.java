package org.bysj.pleural.mapper;

import io.swagger.models.auth.In;
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

     void saveUser(User user);

     User findUserByUsername(@Param("username") String username);

     Integer changePasswordByUsername(@Param("username") String username,@Param("password") String password);
     int updateUser(User user);

     User findById();

     List<User> listUsersPage();

     Integer activeUser(@Param("code") String code);

     Integer countUsers();

     Integer batchDel(List<Integer> ids);


}
