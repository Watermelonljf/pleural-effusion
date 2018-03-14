package org.bysj.pleural.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>类名: User</pre>
 * <pre>描述: 用户实体类</pre>
 * <pre>日期: 2018/3/13  13:13</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 6660357355644810510L;

    private Integer id;

    private String username;  //用户名

    private String password;  //密码

    private Integer age;

    private String telphone; //联系电话

    private String salt;     //加密盐值

    private Integer roleId;  //角色Id

    private Integer locked;   //是否锁定

    private Date createTime;

    private Date updateTime;

}
