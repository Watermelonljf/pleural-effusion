package org.bysj.pleural.web;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.dto.model.TrainModelRequestDTO;
import org.bysj.pleural.facade.TrainModelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：模型训练控制器
 * 作者: Watermelon_R
 * 时间：2017/11/20.
 */
@RestController
@Slf4j
@RequestMapping(value="/model")
public class ModelTrainController {

    @Autowired
    private TrainModelFacade trainModelFacade;

    @PostMapping(value = "train")
    public Response<?> trainModel(TrainModelRequestDTO request){
        FoaParamsDTO foaParamsDTO = new FoaParamsDTO(request.getMaxgen(),request.getPopSize());
        trainModelFacade.trainModel(foaParamsDTO);
        return Response.success();
    }

    @GetMapping(value="/get/trainData")
    public PageResponse<?> queryPageTrainData(@RequestParam(value = "pageIndex") Integer pageIndex
            ,@RequestParam(value = "pageSize") Integer pageSize){
        return trainModelFacade.queryPageTrainData(pageIndex,pageSize);
    }

}
