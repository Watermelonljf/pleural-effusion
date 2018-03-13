package org.bysj.pleural.enumeration;

/**
 * className: AlgorithmEnum
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/2/26
 */
public enum  AlgorithmEnum {
    ALGORITHM_FOA("001","FOA"),
    ALGORITHM_GRID("002","GRID");

    private String Code;
    private String Text;

    AlgorithmEnum(String code, String text) {
        Code = code;
        Text = text;
    }
}
