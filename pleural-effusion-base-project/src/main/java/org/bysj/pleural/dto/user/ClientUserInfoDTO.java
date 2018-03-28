package org.bysj.pleural.dto.user;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>类名: ClientUserInfoDTO</pre>
 * <pre>描述: 客户端用户信息</pre>
 * <pre>日期: 2018/3/28  14:52</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientUserInfoDTO {

    private Integer userId;

    private String username;  //用户名

    private Integer age;

    private String token;
}
