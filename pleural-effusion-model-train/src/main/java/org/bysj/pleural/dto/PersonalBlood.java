package org.bysj.pleural.dto;

import lombok.Data;
import lombok.ToString;
import org.bysj.pleural.svm.SvmNode;

/**
 * className: PersonalBlood
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/16
 */
@Data
@ToString
public class PersonalBlood {

    private Integer id;

    private SvmNode[] blood;

    private Double result;
}
