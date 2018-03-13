package org.bysj.pleural.svm;

/**
 * className: QMatrix
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/1/4
 */
abstract public class QMatrix {
    abstract float[] get_Q(int column, int len);
    abstract double[] get_QD();
    abstract void swap_index(int i, int j);
}
