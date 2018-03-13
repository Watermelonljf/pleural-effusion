package org.bysj.pleural.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.mapper.UserMapper;
import org.bysj.pleural.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * <pre>类名: UserSerivceImpl</pre>
 * <pre>描述: 用户业务实现类</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/13  13:51</pre>
 * <pre>作者: ljianf</pre>
 */
@Service
public class UserSerivceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSerivceImpl.class);

    @Autowired
    private UserMapper userMapper;


    public User regsiterUser(User user) throws UnsupportedEncodingException {
        //个人随机盐值
        String salt = UUID.randomUUID().toString();
        //设置加密后的密码
        user.setPassword(DigestUtils.md5Hex(user.getPassword()+salt));
        user.setSalt(salt);
        userMapper.insert(user);
        return user;
    }

    public User login(User user) {
        return null;
    }

    public void logout(User user) {

    }

    public User changePassword(User user) {
        return null;
    }


    public List<User> listUserPage(){
        return null;
    }
}
