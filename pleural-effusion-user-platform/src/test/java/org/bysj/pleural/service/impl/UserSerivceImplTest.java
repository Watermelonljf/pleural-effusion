package org.bysj.pleural.service.impl;

import org.bysj.pleural.UserPlatformApplication;
import org.bysj.pleural.bean.User;
import org.bysj.pleural.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>类名: UserSerivceImplTest</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/13  14:48</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
public class UserSerivceImplTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback(true) //完成后事务回滚
    public void regsiterUser() throws Exception {
        for(int i=13;i<15;i++) {
            User user = new User();
            user.setUsername("watermelon"+i);
            user.setPassword("ljf645712");
            user.setTelphone("15858540012");
            user.setRoleId(1);
            userService.regsiterUser(user);
            System.out.println(user.getId());
        }

    }

    public void testListPageUser(){

    }
    @Test
    public void login() throws Exception {

    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void changePassword() throws Exception {

    }

}