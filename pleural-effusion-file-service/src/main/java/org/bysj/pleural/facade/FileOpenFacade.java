package org.bysj.pleural.facade;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.constant.file.FileConstants;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.dto.model.PredictXqjyDTO;
import org.bysj.pleural.dto.model.XqjyDTO;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.PoiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * className: FileOpenFacade
 * describe: 文件打开
 * author: Watermelon_R
 * date:   2018/4/11
 */
@Component
@Slf4j
public class FileOpenFacade {

    @Autowired
    private PoiHelper poiHelper;

    public Response<?> getExcelFileData(MultipartFile file) {

        try {
            byte[] content = file.getBytes();
            if(content==null){
                throw new BusinessException(FileConstants.FILE_CONTENT_EMPTY);
            }
            List<PredictXqjyDTO> data = poiHelper.getExcelDataToList(file, PredictXqjyDTO.class);
            return Response.success(data);
        } catch (Exception e) {
            if(e instanceof IOException) {
                log.error("从MultipartFile中获取文件字节数组失败！原因：{}", e);
                throw new BusinessException(FileConstants.FILE_OPEN_ERROR);
            }else if(e instanceof IllegalAccessException){
                log.error("原因：{}", e);
                throw new BusinessException(FileConstants.FILE_OPEN_ERROR);
            }else{
                log.error("原因：{}", e);
                throw new BusinessException(FileConstants.FILE_OPEN_ERROR);
            }
        }



    }
}
