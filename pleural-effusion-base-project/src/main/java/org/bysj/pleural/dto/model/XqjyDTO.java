package org.bysj.pleural.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * className: XqjyDTO
 * describe: 胸腔积液DTO
 * author: Watermelon_R
 * date:   2018/2/24
 */
@Data
@NoArgsConstructor
@ToString
public class XqjyDTO {
    private Integer result;// 诊断结果
    private BigDecimal height; // 患者身高
    private BigDecimal weight; // 体重
    private Integer diabetes;// 是否有过糖尿病史1是2不是
    private BigDecimal temperature;// 患者体温
    private Integer gender; // 性别1男2女
    private Integer age; // 年龄
    private BigDecimal whiteCell; // 白细胞%
    private BigDecimal neutrophils; // 中性粒细胞%
    private BigDecimal acidGranulocyte;// 酸性粒细胞%
    private BigDecimal alkalineGranulocyte;// 碱性粒细胞
    private BigDecimal monocyte;// 单核细胞
    private BigDecimal lymphocyte;// 淋巴细胞
    private BigDecimal acidGranulocyteAbs;// 酸性粒绝对值
    private BigDecimal neutrophilsAbs;// 中性粒细胞绝对值
    private BigDecimal monocyteAbs;// 单核细胞绝对值
    private BigDecimal lymphocyteAbs;// 淋巴细胞
    private BigDecimal alkalineGranulocyteAbs;// 碱性细胞绝对值
    private BigDecimal redBloodCell;// 红细胞
    private BigDecimal hemoglobin; // 血红蛋白
    private BigDecimal hematocrit; // 红细胞压积
    private BigDecimal avgRedBloodCell;// 平均红细胞
    private BigDecimal avgHemoglobinAmount;// 平均血红蛋白量
    private BigDecimal avgHemoglobinConcentration;// 平均血红蛋白浓度
    private BigDecimal rbcWidth;// RBC宽度
    private BigDecimal rbcSd;// RBCSD值
    private BigDecimal platelet;// 血小板
    private BigDecimal plateletAggregation;// 血小板压积;
    private BigDecimal avgPlateletVolume;// 平均血小板体积
    private BigDecimal avgPlateletSd;// 平均血小板sd值
    private BigDecimal bigPlateletRatio;// 大型血小板比率
}
