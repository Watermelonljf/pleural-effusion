package org.bysj.pleural.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * className: EachGenResult
 * describe: 结果消息对象
 * author: Watermelon_R
 * date:   2018/4/10
 */
@Data
@ToString
@NoArgsConstructor
public class EachGenResult implements Serializable {

    private List<Integer>  gens = new ArrayList<>();   //迭代次数（很坐标）

    private List<Double> accs = new ArrayList<>();     //精度值（纵坐标）

    private List<Double> avgs = new ArrayList<>();    //平均值（纵坐标）
 }
