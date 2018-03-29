package org.bysj.pleural.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>类名: UserDTO</pre>
 * <pre>描述: 用户DTO</pre>
 * <pre>日期: 2018/3/28  13:33</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private String username;  //用户名


    private String password;  //密码


    private String vercode;


    private Integer age;


    private String telphone; //联系电话


    private String salt;     //加密盐值


    private Integer roleId;  //角色Id


    private Integer locked;   //是否锁定


    private Date createTime;


    private Date updateTime;
}
