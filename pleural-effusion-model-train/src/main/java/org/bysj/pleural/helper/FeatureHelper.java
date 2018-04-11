package org.bysj.pleural.helper;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.svm.SvmNode;
import org.bysj.pleural.svm.SvmProblem;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * className: FeatureHelper
 * describe: 特征选择帮助类
 * author: Watermelon_R
 * date:   2018/4/1
 */
@Component
@Slf4j
public class FeatureHelper {


    public SvmProblem choose(SvmProblem sp){

        SvmProblem svmProblem = new SvmProblem();
        svmProblem.setL(sp.getL());
        svmProblem.setY(sp.getY());
        
        //获取特征子集序列
        Map<String,Object> map = createRandom(sp.getX()[0].length);
        //重组的特征
        SvmNode[][] features = new SvmNode[sp.getL()][(Integer)map.get("count")];
        boolean[] randoms=((boolean[])map.get("list"));
        for(int i=0;i<sp.getL();i++) {
            int feaIdx = 0; //重组后的特征序号
            for(int j=0;j<randoms.length;j++){
                SvmNode eleFea = new SvmNode();
                if (randoms[j]) {
                    //特征序号
                    eleFea.index=feaIdx;
                    //特征值
                    eleFea.value=sp.getX()[i][j].value;
                    features[i][feaIdx]=eleFea;
                    feaIdx++;
                }
            }
        }
        svmProblem.setX(features);
        return svmProblem;

    }

    private Map<String,Object> createRandom(int featureCount){
        boolean[] list = new boolean[featureCount];
        int count=0;
        for(int i=0;i<featureCount;i++) {
            double random = Math.random();
            if (random > 0.5) {
                list[i]=true;
                count++;
            } else {
                list[i]=false;
            }
        }
        Map<String,Object> map = Maps.newHashMap();
        map.put("list",list);
        map.put("count",count);
        return map;
    }
}
