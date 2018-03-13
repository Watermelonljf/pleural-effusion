package org.bysj.pleural.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * className: FoaParamsDTO
 * describe: 果蝇算法配置参数DTO
 * author: Watermelon_R
 * date:   2018/2/26
 */
@Data
@AllArgsConstructor
@ToString
public class FoaParamsDTO {
    private int maxgen;   // 最大迭代次数
    private int popSize;  //总群个体数
}
