package org.bysj.pleural.web;

import com.alibaba.fastjson.JSON;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.PredictFacade;
import org.bysj.pleural.svm.SvmNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * className: PredictController
 * describe: 预测控制器
 * author: Watermelon_R
 * date:   2018/4/12
 */
@RestController
@RequestMapping(value = "/predict")
public class PredictController {


    @Autowired
    private PredictFacade predictFacade;

    @PostMapping(value = "/batch")
    public Response<?> predictHasPleural(@RequestParam(value="dataStr") String datas){
        List<SvmNode[]> svmNodes = JSON.parseArray(datas, SvmNode[].class);
        if(svmNodes.size()==0) {
            throw new BusinessException("预测样本为空！");
        }
        return predictFacade.predict(svmNodes);
    }
}
