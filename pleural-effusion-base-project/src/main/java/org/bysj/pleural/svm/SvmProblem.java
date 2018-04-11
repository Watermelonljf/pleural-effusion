package org.bysj.pleural.svm;

import lombok.Data;

import java.io.Serializable;

/**
 * className: SvmProblem
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/1/4
 */
@Data
public class SvmProblem implements Serializable {
    public int l;
    public double[] y; //label数组
    public SvmNode[][] x;
}
