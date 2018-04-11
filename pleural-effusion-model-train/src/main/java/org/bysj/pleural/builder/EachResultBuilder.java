package org.bysj.pleural.builder;

import org.bysj.pleural.bean.EachGenResult;

/**
 * className: EachResultBuilder
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/10
 */
public class EachResultBuilder {

    public static EachGenResult builder(EachGenResult eachGenResult,Integer gen, Double acc, Double avgs){
        eachGenResult.getGens().add(gen);
        eachGenResult.getAccs().add(acc);
        eachGenResult.getAvgs().add(avgs);
        return eachGenResult;
    }

}
