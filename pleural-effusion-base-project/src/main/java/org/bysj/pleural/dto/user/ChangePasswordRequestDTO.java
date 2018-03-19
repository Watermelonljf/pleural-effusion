package org.bysj.pleural.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <pre>类名: ChangePasswordRequestDTO</pre>
 * <pre>描述: 修改密码请求DTO</pre>
 * <pre>日期: 2018/3/19  11:13</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class ChangePasswordRequestDTO implements Serializable{

    private String username;

    private String oldPassword;

    private String newPassword;

}
