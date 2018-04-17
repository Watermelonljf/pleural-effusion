package org.bysj.pleural.facade;

import com.github.pagehelper.PageHelper;
import org.bysj.pleural.bean.Patient;
import org.bysj.pleural.bean.PatientPleural;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * className: PatientFacade
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/14
 */
@Component
public class PatientFacade {

    @Autowired
    private PatientService patientService;

    public PageResponse<?> getPatientsPage(Integer pageIndex, Integer pageSize) {
        Integer count = patientService.countAll();
        if (count == 0) {
            PageResponse.success(count, new ArrayList<Patient>());
        }
        return PageResponse.success(count, patientService.getPatientsPage(pageIndex, pageSize));
    }

    public Response<?> savePatient(Patient patient){

        if(patientService.savePatientMapper(patient)==1){
            return Response.success();
        }
        return Response.error();
    }

    public PageResponse<?> getBloodByPatient(Integer pageIndex,Integer pageSize, Integer patientId){

        int count = patientService.countByPatientId(patientId);
        if(count==0){
            return PageResponse.success(count,new ArrayList<PatientPleural>());
        }
        PageHelper.startPage(pageIndex,pageSize);
        return PageResponse.success(count,patientService.getBloodByPatientId(patientId));
    }


    public Response<?> confirmResult(Integer sampleId,Integer result){
            if(patientService.confirmResult(sampleId, result)==1){
                return Response.success();
            }
            return Response.error();
    }
}
