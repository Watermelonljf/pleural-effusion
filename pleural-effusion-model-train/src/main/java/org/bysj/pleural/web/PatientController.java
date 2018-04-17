package org.bysj.pleural.web;

import org.bysj.pleural.bean.Patient;
import org.bysj.pleural.dto.common.PageResponse;
import org.bysj.pleural.dto.common.Response;
import org.bysj.pleural.facade.PatientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * className: PatientController
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/14
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientFacade patientFacade;

    @GetMapping("/page")
    public PageResponse<?> getPatientsPage(Integer pageIndex, Integer pageSize) {
      return patientFacade.getPatientsPage(pageIndex,pageSize);
    }

    @PostMapping("/save")
    public Response<?> savePatient(Patient patient){

        return patientFacade.savePatient(patient);
    }

    @GetMapping("/getByPatientId")
    public PageResponse<?> getBloodByPatientId(@RequestParam("pageIndex") Integer pageIndex,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("patientId") Integer patientId){
        return patientFacade.getBloodByPatient(pageIndex, pageSize, patientId);
    }

    @PostMapping("/confirmNotPe")
    public Response<?> doctorConfirmPe(@RequestParam("sampleId") Integer sampleId){
        return patientFacade.confirmResult(sampleId,2);
    }

    @PostMapping("/confirmPe")
    public Response<?> doctorConfirmNotPe(@RequestParam("sampleId") Integer sampleId){
        return patientFacade.confirmResult(sampleId,1);
    }
}
