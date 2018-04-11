package org.bysj.pleural.service.impl;

import org.bysj.pleural.DiagnoseApplication;
import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.facade.TrainModelFacade;
import org.bysj.pleural.helper.MqSenderHelper;
import org.bysj.pleural.service.ModelTrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Watermelon_R on 2017/12/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiagnoseApplication.class)
public class FOATrainServiceImplTest {


    @Autowired
    private ModelTrainService modleTrainService;

    @Autowired
    private MqSenderHelper mqSenderHelper;

    @Autowired
    private TrainModelFacade trainModelFacade;

    @Test
    public void trainModle() throws Exception {
        FoaParamsDTO foaParamsDTO = new FoaParamsDTO(5,5);
        trainModelFacade.trainModel(foaParamsDTO);
    }

    @Test
    public void getAllXqjy() throws Exception {
        List<Xqjy> allXqjy = modleTrainService.getTrainData();
        Arrays.asList(allXqjy).toString();
    }

    @Test
    public void testSvmParams(){
        modleTrainService.getModle(new FoaParamsDTO(10,100));
    }

    @Test
    public void testMq(){
        mqSenderHelper.sendTrainResult();
    }

}