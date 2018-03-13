package org.bysj.pleural.converter;

import com.google.common.base.Converter;
import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.dto.XqjyDTO;
import org.bysj.pleural.utils.CollectionsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * className: XqjyDTOConverter
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/2/24
 */
@Component
public class XqjyDTOConverter {

    public List<XqjyDTO> convertFor(List<Xqjy> xqjys) {

        List<XqjyDTO> list = new ArrayList<>();

        if(CollectionsUtil.isEmpty(xqjys)){
            return list;
        }
        for(Xqjy xqjy : xqjys){
            list.add(convert(xqjy));
        }
        return list;

    }

    private XqjyDTO convert(Xqjy xqjy){
        XqjyDTO xqjyDTO = new XqjyDTO();
        BeanUtils.copyProperties(xqjy,xqjyDTO);
        return xqjyDTO;

    }
}
