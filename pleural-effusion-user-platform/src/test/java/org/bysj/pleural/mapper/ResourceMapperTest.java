package org.bysj.pleural.mapper;

import org.bysj.pleural.UserPlatformApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * <pre>类名: ResourceMapperTest</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/22  14:49</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
public class ResourceMapperTest {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void listUserResource() throws Exception {
        System.out.print(resourceMapper.listUserResource(1));
        System.out.print(resourceMapper.listUserResource(3));
    }

}