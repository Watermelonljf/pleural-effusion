package org.bysj.pleural.bean;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 胸腔积液实体类
 * @author Watermelon_R
 *
 */
@Data
@NoArgsConstructor
@ToString
public class Xqjy {
	private Integer id;
	private Integer result;// 诊断结果
	private BigDecimal height; // 患者身高
	private BigDecimal weight; // 体重
	private Integer diabetes;// 是否有过糖尿病史1是2不是
	private BigDecimal temperature;// 患者体温 2
	private Integer gender; // 性别1男2女
	private Integer age; // 年龄  3
	private BigDecimal whiteCell; // 白细胞%
	private BigDecimal neutrophils; // 中性粒细胞%
	private BigDecimal acidGranulocyte;// 酸性粒细胞%
	private BigDecimal alkalineGranulocyte;// 碱性粒细胞
	private BigDecimal monocyte;// 单核细胞 1
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
