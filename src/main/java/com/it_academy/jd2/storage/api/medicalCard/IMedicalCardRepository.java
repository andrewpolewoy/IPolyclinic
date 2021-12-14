package com.it_academy.jd2.storage.api.medicalCard;

import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.TreeSet;


public interface IMedicalCardRepository extends JpaRepository<MedicalСard,Long> {
    Set<MedicalСard> findAllByUser(User user);
    MedicalСard findById(Integer id);
    Set<MedicalСard> findAllByOrderByDateAsc();
//    List<MedicalСard> findMedicalCardByDoctorAndPatientAndDiagnose(User doctor, User patient, String diagnose);

    @Query("SELECT m FROM MedicalСard m JOIN m.user u WHERE u.id=?1")
    TreeSet<MedicalСard> findAllByUserId(int id);
}
