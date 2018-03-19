package org.bysj.pleural.builder;

import org.apache.commons.beanutils.BeanUtils;
import org.bysj.pleural.bean.Xqjy;

import org.bysj.pleural.dto.model.XqjyDTO;
import org.bysj.pleural.svm.SvmNode;
import org.bysj.pleural.svm.SvmParameter;
import org.bysj.pleural.svm.SvmProblem;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * className: SVMParamsBuilder
 * describe: SVM参数构建Builder
 * author: Watermelon_R
 * date:   2017/12/24
 */
@Component
public class SVMParamsBuilder {


    public SvmProblem getSvmParams(List<XqjyDTO> Xqjys) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        //数据集的长度根据类型对应数据表长度
        int dataSetLength = Xqjys.size();
        //创建数据的格式数组
        SvmNode[][] dataSet = new SvmNode[dataSetLength][30];

        //声明保存标签用的数组
        double[] lables = new double[dataSetLength];
        SvmProblem sp = new SvmProblem();

        //SVM训练数据长度
        sp.l  = dataSetLength;
        //构造数据的结构
        for(int i=0;i<Xqjys.size();i++){
            int count=-1;
            for(Field field:XqjyDTO.class.getDeclaredFields()){
                count++;
                if(count>=0){//result
                    //获取相应类的属性描述器
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), Xqjys.get(i).getClass());
                    //获取该属性的个体方法
                    Method get = pd.getReadMethod();
                    //通过get方法获得对应实例的相应属性值
                    Object val  = get.invoke(Xqjys.get(i), null);
                    if(count==0){
                        lables[i] = Double.valueOf(String.valueOf(val));
                    }else{
                        dataSet[i][count-1] = new SvmNode(); //特征
                        dataSet[i][count-1].index = count-1;
                        dataSet[i][count-1].value = Double.valueOf(String.valueOf(val));
                    }
                }
            }
        }
        //设置SVM训练参数
        sp.x = dataSet;
        //SVM训练数据标签
        sp.y=lables;
        return sp;
    }

}
