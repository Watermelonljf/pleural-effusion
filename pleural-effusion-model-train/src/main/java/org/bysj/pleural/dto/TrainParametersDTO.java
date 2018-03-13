package org.bysj.pleural.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 模型训练参数
 * Created by Watermelon_R on 2017/11/20.
 */
@Data
@Getter
@Setter
public class TrainParametersDTO {
    private String dataName;
    private String model;
    private int maxgen;
    private int popSize;
    private String normalized;
}
