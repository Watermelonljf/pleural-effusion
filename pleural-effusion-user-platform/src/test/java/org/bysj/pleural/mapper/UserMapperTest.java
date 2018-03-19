package org.bysj.pleural.mapper;

import com.github.pagehelper.PageHelper;
import org.bysj.pleural.UserPlatformApplication;
import org.bysj.pleural.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <pre>类名: UserMapperTest</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/19  9:55</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        PageHelper.startPage(0,10);
        List<User> users = userMapper.listUsers();
        users.forEach(user->{
            System.out.println(user.toString());
        });
    }

}