package org.bysj.pleural.service;

import org.bysj.pleural.bean.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * <pre>类名: UserService接口类</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/13  13:37</pre>
 * <pre>作者: ljianf</pre>
 */
public interface UserService {

    /**
     * @Description: 用户注册
     * @date   2018/3/13 13:38
     * @param    user
     * @return  user
     * @author ljianf
     */
    public User regsiterUser(User user) throws UnsupportedEncodingException;


    /**
     * @Description: 用户登录
     * @date   2018/3/13 13:38
     * @param    User
     * @return  user
     * @author ljianf
     */
    public User login(User user);


    /**
     * @Description: 用户登出
     * @date   2018/3/13 13:50
     * @param    user
     * @return
     * @author ljianf
     */
    public void logout(User user);

    /**
     * @Description: 修改密码
     * @date   2018/3/13 13:51
     * @param user
     * @return user
     * @author ljianf
     */
    public User changePassword(User user);


    public List<User> listUserPage();
}
