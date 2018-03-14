package org.bysj.pleural.service;

import org.bysj.pleural.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @Description: 保存用户信息
     * @date   2018/3/14 10:26
     * @param
     * @return
     * @author ljianf
     */
    @Transactional
    public User saveUserInfo(User user);


    /**
     * @Description: 通过用户名查询用户
     * @date   2018/3/14 9:42
     * @param
     * @return
     * @author ljianf
     */
    public User findUserByUsername(String username);

    /**
     * @Description: 修改用户信息
     * @date   2018/3/14 17:11
     * @param
     * @return
     * @author ljianf
     */
    public int updateUserInfo(User user);

    public List<User> listUserPage();
}
