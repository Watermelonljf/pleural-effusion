package org.bysj.pleural.service;


import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.svm.SvmModel;

import java.util.List;

/**
 * Created by Watermelon_R on 2017/11/20.
 */
public interface ModelTrainService {

    /**
     * @Description: 训练获取模型
     * @date   2018/3/20 11:04
     * @param
     * @return
     * @author ljianf
     */
    SvmModel getModle(FoaParamsDTO foaParamsDTO);


    /**
     * @Description: 获取训练信息
     * @date   2018/3/20 11:04
     * @param
     * @return
     * @author ljianf
     */
    <T> List<T> getTrainData();


}
