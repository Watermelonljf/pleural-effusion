package org.bysj.pleural.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bysj.pleural.bean.Patient;
import org.bysj.pleural.bean.PatientPleural;
import org.bysj.pleural.dto.PersonalBlood;

import java.util.List;

/**
 * className: PatientMapper
 * describe: 病人数据接口
 * author: Watermelon_R
 * date:   2018/4/14
 */
@Mapper
public interface PatientMapper {

     Integer savePatientMapper(Patient patient);

     List<Patient> getPatientsPage();

     Integer countAll();

     List<PatientPleural> getBloodByPatientId(Integer patientId);

     Integer countByPatientId(Integer patientId);

     Integer savePredictResult(List<PersonalBlood> datas);

     Integer confirmResult(@Param("sampleId") Integer sampleId,@Param("result") Integer result);
}
