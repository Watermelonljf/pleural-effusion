package org.bysj.pleural.service.impl;

import com.google.common.collect.Lists;
import org.bysj.pleural.constant.model.ModelConstants;
import org.bysj.pleural.dto.PersonalBlood;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.mapper.PatientMapper;
import org.bysj.pleural.service.PredictService;
import org.bysj.pleural.svm.Svm;
import org.bysj.pleural.svm.SvmModel;
import org.bysj.pleural.svm.SvmNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * className: PredictServiceImpl
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/12
 */
@Service
public class PredictServiceImpl implements PredictService {

    private static final String FOA_MODEL_PLEURAL="FOA_MODEL_PLEURAL";

    @Autowired
    private RedisHelp redisHelp;

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<Double> predict(List<PersonalBlood> datas) {
        List<Double> results = Lists.newArrayList();
        if(!redisHelp.containsKey(FOA_MODEL_PLEURAL)){
            throw new BusinessException(ModelConstants.MODEL_NOT_EXISTS);
        }
        SvmModel svmModel = (SvmModel) redisHelp.getValue(FOA_MODEL_PLEURAL);
        datas.forEach(elem->{
            double res = Svm.svm_predict(svmModel,elem.getBlood());
            elem.setResult(res);
            results.add(res);
        });
        this.savePredictResult(datas);
        return results;
    }

    @Transactional
    @Async
    private void savePredictResult(List<PersonalBlood> datas){
            patientMapper.savePredictResult(datas);
    }
}
