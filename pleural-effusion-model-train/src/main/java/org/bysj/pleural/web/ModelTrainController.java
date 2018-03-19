package org.bysj.pleural.web;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.service.ModelTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ModelTrainService modelTrainService;

    @PostMapping(value = "train")
    public Response<?> trainModel(){
        return Response.success();
    }


}
