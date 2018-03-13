package org.bysj.pleural.service;


import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.svm.SvmModel;

import java.util.List;

/**
 * Created by Watermelon_R on 2017/11/20.
 */
public interface ModelTrainService {


    SvmModel getModle();


    List<Xqjy> getAllXqjy();


}
