package org.bysj.pleural.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.bysj.pleural.algorithm.FoaSvm;
import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.builder.SVMParamsBuilder;
import org.bysj.pleural.converter.XqjyDTOConverter;

import org.bysj.pleural.dto.model.BestSvmParamsDTO;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.dto.model.XqjyDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.mapper.TrainMapper;
import org.bysj.pleural.service.ModelTrainService;
import org.bysj.pleural.svm.Svm;
import org.bysj.pleural.svm.SvmModel;
import org.bysj.pleural.svm.SvmParameter;
import org.bysj.pleural.svm.SvmProblem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Watermelon_R on 2017/11/20.
 */
@Service("foaTrainService")
@Primary
public class FOATrainServiceImpl implements ModelTrainService {


    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private SVMParamsBuilder svmParamsBuilder;

    @Autowired
    private XqjyDTOConverter xqjyDTOConverter;

    @Autowired
    private FoaSvm foaSvm;

    private static final Logger LOGGER = LoggerFactory.getLogger(FOATrainServiceImpl.class);


    public SvmModel getModle(FoaParamsDTO foaParamsDTO) {
        List<Xqjy> xqjys = trainMapper.getAllTrainData();
        List<XqjyDTO> xqjyDTOS = xqjyDTOConverter.convertFor(xqjys);
        SvmModel model=null;
        try {
            LOGGER.info("开始转换SVM训练参数");
            SvmProblem svmParams = svmParamsBuilder.getSvmParams(xqjyDTOS);
            LOGGER.info("转换参数结束，成功");
            //利用FOA获取最佳参数对
            BestSvmParamsDTO svmParasByFOA = foaSvm.getSVMParasByFOA(foaParamsDTO, svmParams, xqjys.size());
            LOGGER.info("最佳参数对信息：【C:{},gamma:{}】",svmParasByFOA.getC(),svmParasByFOA.getG());
            //svm参数构造
            SvmParameter svmParameter = new SvmParameter();
            svmParameter.eps=0.001;
            svmParameter.cache_size = 40;
            //设置最优的C和γ
            svmParameter.C = svmParasByFOA.getC();
            svmParameter.gamma = svmParasByFOA.getG();
            //	System.out.println(svm.svm_check_parameter(sp, svmParameter)); //如果参数没有问题，则svm.svm_check_parameter()函数返回null,否则返回error描述。
            Svm s = new Svm();
            //利用最优参数训练保存最优模型
            model = s.svm_train(svmParams, svmParameter);
            model.acc=svmParasByFOA.getAcc(); //保存每个模型的精度
        } catch (Exception e) {
            LOGGER.error("参数转换异常,原因：{}",e);
           throw new BusinessException("参数转换异常");
        }
        return model;
    }

    @Override
    public Integer countAllData() {
        return trainMapper.countAll();
    }

    public List<Xqjy> getTrainData() {
        List<Xqjy> xqjys = trainMapper.getAllTrainData();
        return xqjys;
    }
}
