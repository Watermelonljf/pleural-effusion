package org.bysj.pleural.service.impl;

import org.bysj.pleural.DiagnoseApplication;
import org.bysj.pleural.bean.Xqjy;
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


    @Test
    public void trainModle() throws Exception {
    }

    @Test
    public void getAllXqjy() throws Exception {
        List<Xqjy> allXqjy = modleTrainService.getAllXqjy();
        Arrays.asList(allXqjy).toString();
    }

    @Test
    public void testSvmParams(){
        modleTrainService.getModle();
    }

}