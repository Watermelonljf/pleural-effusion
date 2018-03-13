package org.bysj.pleural.svm;

import java.io.Serializable;

/**
 * className: SvmProblem
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/1/4
 */
public class SvmProblem implements Serializable {
    public int l;
    public double[] y;
    public SvmNode[][] x;
}
