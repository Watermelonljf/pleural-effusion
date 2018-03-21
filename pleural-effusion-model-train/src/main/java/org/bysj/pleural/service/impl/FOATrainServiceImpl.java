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
import org.bysj.pleural.svm.SvmModel;
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
        try {
            LOGGER.info("开始转换SVM训练参数");
            SvmProblem svmParams = svmParamsBuilder.getSvmParams(xqjyDTOS);
            LOGGER.info("转换参数结束，成功");
            //利用FOA获取最佳参数对
            BestSvmParamsDTO svmParasByFOA = foaSvm.getSVMParasByFOA(foaParamsDTO, svmParams, xqjys.size());
            LOGGER.info("最佳参数对信息：【C:{},gamma:{}】",svmParasByFOA.getC(),svmParasByFOA.getG());
        } catch (Exception e) {
            LOGGER.error("参数转换异常,原因：{}",e);
           throw new BusinessException("参数转换异常");
        }
        return null;
    }

    public List<Xqjy> getTrainData() {
        List<Xqjy> xqjys = trainMapper.getAllTrainData();
        return xqjys;
    }
}
