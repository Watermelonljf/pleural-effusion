package org.bysj.pleural.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.bysj.pleural.constant.user.UserMessageConstant;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.user.RoleSaveRequestDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.RoleFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>类名: RoleController</pre>
 * <pre>描述: 角色控制器</pre>
 * <pre>日期: 2018/3/28  10:56</pre>
 * <pre>作者: ljianf</pre>
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private RoleFacade roleFacade;


    @PostMapping(value = "/save")
    public Response<?> saveRoleInfo(@RequestBody RoleSaveRequestDTO request){
        if(StringUtils.isBlank(request.getRole())){
            throw new BusinessException(UserMessageConstant.ROLE_NAME_EMPTY);
        }
        return roleFacade.saveRoleInfo(request);
    }
}
