package org.bysj.pleural.utils;



import org.bysj.pleural.dto.model.BestSvmParamsDTO;

import java.math.BigDecimal;

/**
 * className: SvmResultAnalyseUtil
 * describe: 结果分析工具类
 * author: Watermelon_R
 * date:   2018/2/26
 */
public class SvmResultAnalyseUtil {

    public static BigDecimal resultAnalyse(double[] result,double[] sourceResult){
        int count=0;
        for(int i=0;i<result.length;i++){
            if(result[i]==sourceResult[i]){
                count++;
            }
        }
        System.out.println("预测个数："+result.length);
        System.out.println("正确个数："+count);
        BigDecimal acc=BigDecimal.valueOf(count/(result.length*1.0));
        return acc;
    }

    public static BestSvmParamsDTO findMax(double[] smell){
        BestSvmParamsDTO best = new BestSvmParamsDTO();
        for(int i=0; i<smell.length; i++){
            if(smell[i]>best.getAcc()){
                best.setAcc(smell[i]);
                best.setIndex(i);
            }
        }
        return best;
    }
}
