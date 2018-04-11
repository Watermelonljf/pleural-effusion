package org.bysj.pleural.algorithm;

import org.bysj.pleural.bean.EachGenResult;
import org.bysj.pleural.builder.EachResultBuilder;
import org.bysj.pleural.dto.model.BestSvmParamsDTO;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.helper.FeatureHelper;
import org.bysj.pleural.helper.MqSenderHelper;
import org.bysj.pleural.svm.Svm;
import org.bysj.pleural.svm.SvmParameter;
import org.bysj.pleural.svm.SvmProblem;
import org.bysj.pleural.utils.SvmResultAnalyseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * className: FoaSvm
 * describe: 果蝇优化SVM
 * author: Watermelon_R
 * date:   2018/2/26
 */
@Component
public class FoaSvm {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoaSvm.class);

    @Autowired
    private FeatureHelper featureHepler;

    @Autowired
    private MqSenderHelper mqSenderHelper;

    public BestSvmParamsDTO getSVMParasByFOA(FoaParamsDTO para, SvmProblem sp, int dataSetLength){

        long startTime = System.currentTimeMillis();
        EachGenResult eachGenResult = new EachGenResult();
        LOGGER.info("FOA优化开始,算法开始时间{}",new Date());

        //定义
        double c = 0; //svm参数
        double g = 0;

        double bestCVaccuarcy = 0;
        double avg=0;
        double accCount=0;
        double bestC = 0;
        double bestG = 0;

        double[] X_axis = new double[2];
        double[] Y_axis = new double[2];
        //初始化果蝇群体位置
        for(int i=0;i<2;i++){
            X_axis[i] = Math.random();
            Y_axis[i] = Math.random();
        }

        //设置迭代次数与种群规模
        int maxgen = para.getMaxgen();
        int sizepop = para.getPopSize();
        double[][] X = new double[sizepop][2];
        double[][] Y = new double[sizepop][2];
        double[][] Dis = new double[sizepop][2];
        double[][] S = new double[sizepop][2];
        double[] smell = new double[sizepop];
        SvmParameter svmParameter = new SvmParameter();
        svmParameter.eps=0.001;
        svmParameter.cache_size = 40;

        //寻优开始
        for(int i=0;i<sizepop;i++){
            //初始化果蝇飞行距离
            for(int j=0;j<2;j++){
                X[i][j] = X_axis[j]+20*Math.random()-10;
                Y[i][j] = Y_axis[j]+20*Math.random()-10;
            }

            //求出与原点的距离
            Dis[i][0] = Math.sqrt((Math.pow(X[i][0], 2)+ Math.pow(Y[i][0], 2)));
            Dis[i][1] = Math.sqrt((Math.pow(X[i][1], 2)+ Math.pow(Y[i][1], 2)));

            //味道浓度是距离倒数，求浓度
            S[i][0]=1/Dis[i][0];
            S[i][1]=1/Dis[i][1];

            //设置SVM参数
            c = S[i][0];
            g = S[i][1];

            svmParameter.C = c;
            svmParameter.gamma = g;
            double [] result = new double[dataSetLength];
            System.out.println(Svm.svm_check_parameter(sp, svmParameter)); //如果参数没有问题，则svm.svm_check_parameter()函数返回null,否则返回error描述。
            Svm.svm_cross_validation(sp, svmParameter, 2, result);
            smell[i] = Double.parseDouble(SvmResultAnalyseUtil.resultAnalyse(result, sp.getY()).toString());
            accCount+=smell[i];
        }

        // 寻找最大浓度及下标
        BestSvmParamsDTO bestSvmParamsDTO = SvmResultAnalyseUtil.findMax(smell);
        int index = bestSvmParamsDTO.getIndex();
        //最优的C,G
        bestSvmParamsDTO.setC(S[index][0]);
        bestSvmParamsDTO.setG(S[index][1]);
        bestCVaccuarcy = bestSvmParamsDTO.getAcc();
        X_axis[0] = X[index][0];
        Y_axis[0] = Y[index][0];
        X_axis[1] = X[index][1];
        Y_axis[1] = Y[index][1];

        //发送消息
        EachResultBuilder.builder(eachGenResult,1,new BigDecimal(bestCVaccuarcy)
                .setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue(),new BigDecimal(accCount/sizepop)
                .setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());

        //TODO: 干扰机制引入
        int count=0;
        SvmProblem newSp=null;
        for(int gen = 1; gen <= maxgen; gen++){
            //寻优开始
            accCount = 0;
            for(int i=0;i<sizepop;i++){
               /* if((i>20 && i%20==0) || i==0) {

                    //特征选择
                    newSp = featureHepler.choose(sp);
                }*/

                //初始化果蝇飞行距离
                for(int j=0;j<2;j++){
                    X[i][j] = X_axis[j]+30*Math.random()-10;
                    Y[i][j] = Y_axis[j]+30*Math.random()-10;
                }

                //求出与原点的距离
                Dis[i][0] = Math.sqrt((Math.pow(X[i][0], 2)+ Math.pow(Y[i][0], 2)));
                Dis[i][1] = Math.sqrt((Math.pow(X[i][1], 2)+ Math.pow(Y[i][1], 2)));

                //味道浓度是距离倒数，求浓度
                S[i][0]=1/Dis[i][0];
                S[i][1]=1/Dis[i][1];

                //设置SVM参数
                c = S[i][0];
                g = S[i][1];

                svmParameter.C = c;
                svmParameter.gamma = g;
                double [] result = new double[dataSetLength];
                //如果参数没有问题，则svm.svm_check_parameter()函数返回null,否则返回error描述。
                LOGGER.info("参数检查结果:{}",Svm.svm_check_parameter(sp, svmParameter)==null?true:false);
                Svm.svm_cross_validation(sp, svmParameter, 5, result);
                BigDecimal acc = SvmResultAnalyseUtil.resultAnalyse(result, sp.getY());
                LOGGER.info("第{}代的第{}次寻优",gen,i);
                smell[i] = Double.parseDouble(acc.toString());
                accCount+=smell[i];
            }
            // 寻找最大浓度及下标
            BestSvmParamsDTO tempBest = SvmResultAnalyseUtil.findMax(smell);
            int index2 = tempBest.getIndex();
            if(tempBest.getAcc()>bestCVaccuarcy){
                //最优的C,G
                bestSvmParamsDTO.setAcc(tempBest.getAcc());
                bestSvmParamsDTO.setC(S[index2][0]);
                bestSvmParamsDTO.setG(S[index2][1]);
                LOGGER.info("当前最好精确度：{}",tempBest.getAcc());
                System.out.println("----------->"+S[index2][0]+"     "+S[index2][1]);
                bestCVaccuarcy = tempBest.getAcc();
                //保存当前最优的果蝇
                X_axis[0] = X[index2][0];
                Y_axis[0] = Y[index2][0];
                X_axis[1] = X[index2][1];
                Y_axis[1] = Y[index2][1];
            }/*else{

                count++;
                if(count>maxgen/2){//干扰
                    LOGGER.info("随机干扰开始！");
                    count=0;
                    X_axis[0] += 30*Math.random()-10;
                    Y_axis[0] += 30*Math.random()-10;
                    X_axis[1] += 30*Math.random()-10;
                    Y_axis[1] += 30*Math.random()-10;
                    LOGGER.info("随机干扰结束！");
                }
            }*/
            //TODO：考虑异步
            mqSenderHelper.sendTrainResult(eachGenResult,gen+1,new BigDecimal(bestCVaccuarcy).setScale(4,BigDecimal.ROUND_HALF_UP)
                    .doubleValue(),new BigDecimal(accCount/sizepop)
                    .setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        LOGGER.info("FOA优化结束,算法时间：{}ms，最好精度：{}",System.currentTimeMillis()-startTime,bestSvmParamsDTO.getAcc());
        return bestSvmParamsDTO;
    }
}
