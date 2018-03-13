package org.bysj.pleural.mapper;

import org.bysj.pleural.bean.Xqjy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * className: TrainMapper
 * describe: TODO
 * author: Watermelon_R
 * date:   2017/12/24
 */
@Repository
public interface TrainMapper {

    List<Xqjy> getAllTrainData();
}
