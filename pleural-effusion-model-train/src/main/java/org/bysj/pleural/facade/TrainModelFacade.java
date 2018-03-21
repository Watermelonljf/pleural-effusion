package org.bysj.pleural.facade;

import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.service.ModelTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * className: TrainModelFacade
 * describe: 模型训练Facade层
 * author: Watermelon_R
 * date:   2017/12/24
 */
@Component
public class TrainModelFacade {


    @Autowired
    private ModelTrainService modelTrainService;

    /**
     * @Description: 训练方法异步调用
     * @date   2018/3/20 11:16
     * @param foaParamsDTO
     * @return
     * @author ljianf
     */
    @Async
    public void trainModel(FoaParamsDTO foaParamsDTO){
        modelTrainService.getModle(foaParamsDTO);
    }
}
