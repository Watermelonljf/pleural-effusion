package org.bysj.pleural.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * className: PatientFacade
 * describe: 病人信息
 * author: Watermelon_R
 * date:   2018/4/14
 */
@Data
@ToString
public class Patient {

    private Integer id;

    private String patientName;

    private String sex;

    private String telephone;

    private String  address;

    private String history;

    private Date createTime;

    private Date updateTime;
}
