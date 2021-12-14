package com.it_academy.jd2.service.doctor;

import com.it_academy.jd2.model.doctor.DoctorInfo;
import com.it_academy.jd2.service.api.doctor.IDoctorInfoService;
import com.it_academy.jd2.storage.api.people.IDoctorInfoRepository;

import java.util.List;

public class DoctorInfoService implements IDoctorInfoService {

    private IDoctorInfoRepository doctorInfoRepository;

    public DoctorInfoService(IDoctorInfoRepository doctorInfoRepository) {
        this.doctorInfoRepository = doctorInfoRepository;
    }

    @Override
    public List<DoctorInfo> getAll() {
        return doctorInfoRepository.findAll();
    }

    @Override
    public DoctorInfo getInfoById(int id) {
        return doctorInfoRepository.findById(id);
    }

    @Override
    public boolean update(DoctorInfo doctorInfo, int id) {
        DoctorInfo doctorInfoNew = doctorInfoRepository.findById(id);
        doctorInfoNew.setExperience(doctorInfo.getExperience());
        doctorInfoNew.setUserId(doctorInfo.getUserId());
        doctorInfoNew.setEducation(doctorInfo.getEducation());
        doctorInfoNew.setLastPlaceOfWork(doctorInfo.getLastPlaceOfWork());
        doctorInfoNew.setLastPosition(doctorInfo.getLastPosition());
        doctorInfoNew.setRating(doctorInfo.getRating());
        DoctorInfo doctorInfoSaved = doctorInfoRepository.save(doctorInfoNew);
        if(doctorInfoSaved.equals(doctorInfoNew)){
            return true;
        } else return false;
    }

    @Override
    public DoctorInfo add(DoctorInfo doctorInfo) {
        return doctorInfoRepository.save(doctorInfo);
    }

    @Override
    public DoctorInfo getByUserId(int id) {
        return doctorInfoRepository.findByUserId(id);
    }
}
