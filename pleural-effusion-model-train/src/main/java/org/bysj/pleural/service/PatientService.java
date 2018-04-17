package org.bysj.pleural.service;

import org.bysj.pleural.bean.Patient;
import org.bysj.pleural.bean.PatientPleural;

import java.util.List;

/**
 * className: PatientService
 * describe: 病人
 * author: Watermelon_R
 * date:   2018/4/14
 */

public interface PatientService {

    Integer savePatientMapper(Patient patient);

    List<Patient> getPatientsPage(Integer pageIndex,Integer pageSize);

    Integer countAll();

    List<PatientPleural> getBloodByPatientId(Integer patientId);

    Integer countByPatientId(Integer patientId);

    Integer confirmResult(Integer sampleId,Integer doctorResult);
}
