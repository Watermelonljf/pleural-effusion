package org.bysj.pleural.svm;

import java.io.Serializable;

/**
 * className: SvmModel
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/1/4
 */
public class SvmModel implements Serializable {

    private static final long serialVersionUID = -461151945465307898L;
    public SvmParameter param;    // parameter
    public int nr_class;        // number of classes, = 2 in regression/one class svm
    public int l;            // total #SV
    public SvmNode[][] SV;    // SVs (SV[l])
    public double[][] sv_coef;    // coefficients for SVs in decision functions (sv_coef[k-1][l])
    public double[] rho;        // constants in decision functions (rho[k*(k-1)/2])
    public double[] probA;         // pariwise probability information
    public double[] probB;
    public int[] sv_indices;       // sv_indices[0,...,nSV-1] are values in [1,...,num_traning_data] to indicate SVs in the training set

    // for classification only

    public int[] label;        // label of each class (label[k])
    public int[] nSV;        // number of SVs for each class (nSV[k])
    // nSV[0] + nSV[1] + ... + nSV[k-1] = l

    public double acc;
}
