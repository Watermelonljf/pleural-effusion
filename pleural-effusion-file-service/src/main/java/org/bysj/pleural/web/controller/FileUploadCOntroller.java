package org.bysj.pleural.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.constant.file.FileConstants;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.facade.FileOpenFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * className: FileUploadCOntroller
 * describe: 文件上传控制器
 * author: Watermelon_R
 * date:   2018/4/11
 */
@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileUploadCOntroller {

    @Autowired
    private FileOpenFacade fileOpenFacade;

    @PostMapping(value = "/open")
    public Response<?> openFileGetData(MultipartFile file){
        if(Objects.isNull(file)){
            throw new BusinessException(FileConstants.FILE_CONTENT_EMPTY);
        }
        log.info(file.getOriginalFilename());
        return fileOpenFacade.getExcelFileData(file);
    }
}
