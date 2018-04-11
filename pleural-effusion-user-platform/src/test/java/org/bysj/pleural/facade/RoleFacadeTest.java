package org.bysj.pleural.facade;

import io.swagger.models.auth.In;
import org.bysj.pleural.UserPlatformApplication;
import org.bysj.pleural.dto.user.RoleSaveRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <pre>类名: RoleFacadeTest</pre>
 * <pre>描述: </pre>
 * <pre>日期: 2018/3/28  11:14</pre>
 * <pre>作者: ljianf</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserPlatformApplication.class)
public class RoleFacadeTest {

    @Autowired
    private RoleFacade roleFacade;

    @Test
    public void saveRoleInfo() throws Exception {

        RoleSaveRequestDTO roleSaveRequestDTO = new RoleSaveRequestDTO();

        roleSaveRequestDTO.setRole("游客");
        roleSaveRequestDTO.setDescription("个梵蒂冈");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
       /* roleSaveRequestDTO.setResourceIds(list);
        roleFacade.saveRoleInfo(roleSaveRequestDTO);*/
    }

}