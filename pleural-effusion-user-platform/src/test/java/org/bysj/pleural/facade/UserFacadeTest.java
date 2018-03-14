package org.bysj.pleural.facade;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.UserPlatformApplication;
import org.bysj.pleural.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>类名: UserFacadeTest</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/14  15:15</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
@Slf4j
public class UserFacadeTest {

    @Autowired
    private UserFacade userFacade;

    @Transactional
    @Rollback(true)
    @Test
    public void regsiterUser() throws Exception {
        for(int i=13;i<15;i++) {
            User user = new User();
            user.setUsername("watermelon"+i);
            user.setPassword("ljf645712");
            user.setTelphone("15858540012");
            user.setRoleId(1);
            userFacade.regsiterUser(user);
            System.out.println(user.getId());
        }
    }

    @Test
    public void login() throws Exception {
        User user = new User();
        user.setUsername("watermelon1");
        user.setPassword("ljf645712");
        String token = userFacade.login(user);
        log.info(token);
    }
}