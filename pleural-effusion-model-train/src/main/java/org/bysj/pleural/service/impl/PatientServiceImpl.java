package org.bysj.pleural.service.impl;

import com.github.pagehelper.PageHelper;
import org.bysj.pleural.bean.Patient;
import org.bysj.pleural.bean.PatientPleural;
import org.bysj.pleural.mapper.PatientMapper;
import org.bysj.pleural.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * className: PatientServiceImpl
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/4/14
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Integer savePatientMapper(Patient patient) {
        return patientMapper.savePatientMapper(patient);
    }

    @Override
    public List<Patient> getPatientsPage(Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return patientMapper.getPatientsPage();
    }

    @Override
    public Integer countAll() {
        return patientMapper.countAll();
    }

    @Override
    public List<PatientPleural> getBloodByPatientId(Integer patientId) {
        int count= patientMapper.countByPatientId(patientId);
        if(count==0){

        }
        return patientMapper.getBloodByPatientId(patientId);
    }

    @Override
    public Integer countByPatientId(Integer patientId) {
        return patientMapper.countByPatientId(patientId);
    }

    @Override
    @Transactional
    public Integer confirmResult(Integer sampleId, Integer result) {
        return patientMapper.confirmResult(sampleId,result);
    }
}
