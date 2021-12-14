package com.it_academy.jd2.service.api.doctor;

import com.it_academy.jd2.model.doctor.DoctorInfo;
import java.util.List;

public interface IDoctorInfoService {
    List<DoctorInfo> getAll();
    DoctorInfo getInfoById(int id);
    boolean update(DoctorInfo doctorInfo, int id);
    DoctorInfo add(DoctorInfo doctorInfo);
    DoctorInfo getByUserId(int id);

}
