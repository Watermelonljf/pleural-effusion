package org.bysj.pleural.facade;

import org.bysj.pleural.service.ModelTrainService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * className: TrainModelFacade
 * describe: 模型训练Facade层
 * author: Watermelon_R
 * date:   2017/12/24
 */
public class TrainModelFacade {


    @Autowired
    private ModelTrainService modelTrainService;

    public void trainModel(){
    }
}
