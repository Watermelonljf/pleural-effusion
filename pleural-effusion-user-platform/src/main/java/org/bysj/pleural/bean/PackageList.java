package org.bysj.pleural.bean;

import lombok.Data;
import lombok.ToString;
import org.bysj.pleural.dto.user.RoleDTO;

import java.util.List;

/**
 * className: PackageList
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/9
 */
@Data
@ToString
public class PackageList {

    private List<Role> roles;

}
