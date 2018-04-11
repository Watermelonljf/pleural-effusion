package org.bysj.pleural.facade;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.model.FoaParamsDTO;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.service.ModelTrainService;
import org.bysj.pleural.svm.Svm;
import org.bysj.pleural.svm.SvmModel;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * className: TrainModelFacade
 * describe: 模型训练Facade层
 * author: Watermelon_R
 * date:   2017/12/24
 */
@Component
@Slf4j
public class TrainModelFacade {


    private static final String MODEL_KEY="FOA_MODEL_PLEURAL";
    @Autowired
    private ModelTrainService modelTrainService;

    @Autowired
    private RedisHelp redisHelp;

    /**
     * @Description: 训练方法异步调用
     * @date   2018/3/20 11:16
     * @param foaParamsDTO
     * @return
     * @author ljianf
     */
    @Async
    public void trainModel(FoaParamsDTO foaParamsDTO){
        SvmModel modle = modelTrainService.getModle(foaParamsDTO);
        //缓存模型
        redisHelp.cacheValue(MODEL_KEY,modle);
    }

    /**
     * @Description: 分页获取训练数据
     * @date   2018/3/20 11:16
     * @return
     * @author ljianf
     */
    public PageResponse<?> queryPageTrainData(Integer pageIndex,Integer pageSize){
        Integer count = modelTrainService.countAllData();

        if(count==0){
            return PageResponse.success(count,new ArrayList<Xqjy>());
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<Xqjy> trainData = modelTrainService.getTrainData();
        return PageResponse.success(count,trainData);

    }
}
