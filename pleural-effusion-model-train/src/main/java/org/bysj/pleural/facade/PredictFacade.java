package org.bysj.pleural.facade;

import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.service.PredictService;
import org.bysj.pleural.svm.SvmNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * className: PredictFacade
 * describe: 预测Facade
 * author: Watermelon_R
 * date:   2018/4/12
 */
@Component
public class PredictFacade {

    @Autowired
    private PredictService predictService;


    public Response<?> predict(List<SvmNode[]> datas){
        return Response.success(predictService.predict(datas));
    }

}
