package com.it_academy.jd2.storage.api.medicalCard;

import com.it_academy.jd2.model.patient.Diagnosis;
import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.patient.enums.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiagnosisRepository extends JpaRepository<Diagnosis,Integer> {
    List<Diagnosis> findAllByCard(MedicalСard card);
    Diagnosis findFirstByHealthStatusAndCard(HealthStatus healthStatus, MedicalСard card);

}
