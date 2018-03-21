package org.bysj.pleural.mapper;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.UserPlatformApplication;
import org.bysj.pleural.bean.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>类名: RoleMapperTest</pre>
 * <pre>描述: </pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/21  19:03</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
@Slf4j
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    @Transactional
    @Rollback(true)
    public void saveRole() throws Exception {
        Role role = new Role();
        role.setRole("超级管理员");
        role.setAvailable(1);
        role.setDescription("拥有系统所有权限");
        Integer count = roleMapper.saveRole(role);
        log.info(count+"");
    }

}