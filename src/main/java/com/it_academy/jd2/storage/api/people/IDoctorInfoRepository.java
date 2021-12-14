package com.it_academy.jd2.storage.api.people;

import com.it_academy.jd2.model.doctor.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDoctorInfoRepository extends JpaRepository<DoctorInfo, Integer> {
    DoctorInfo findById(int id);

    @Query("SELECT d FROM DoctorInfo d JOIN d.doctor u WHERE u.id=?1")
    DoctorInfo findByUserId(int id);
}
