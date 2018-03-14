package org.bysj.pleural.service.impl;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User saveUserInfo(User user) {
        userMapper.saveUser(user);
        return user;
    }

    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int updateUserInfo(User user) {
        return 0;
    }


    @Override
    public List<User> listUserPage(){
        return null;
    }
}
