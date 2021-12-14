package com.it_academy.jd2.service.api.patient;

import com.it_academy.jd2.model.patient.Diagnosis;
import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.patient.enums.HealthStatus;

import java.util.List;

public interface IDiagnosisService {
    List<Diagnosis> getAllByCard(MedicalСard card);
    Diagnosis getStatusDiagnosis(MedicalСard card, HealthStatus status);
    Diagnosis savaDiagnosis(Diagnosis diagnosis);
}
