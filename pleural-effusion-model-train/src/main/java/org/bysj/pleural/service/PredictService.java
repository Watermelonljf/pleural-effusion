package org.bysj.pleural.service;

import org.bysj.pleural.dto.PersonalBlood;
import org.bysj.pleural.svm.SvmNode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className: PredictService
 * describe: 预测服务
 * author: Watermelon_R
 * date:   2018/4/12
 */

public interface PredictService {

    List<Double> predict(List<PersonalBlood> datas);
}
