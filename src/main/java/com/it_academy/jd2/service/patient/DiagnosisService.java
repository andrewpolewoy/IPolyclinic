package com.it_academy.jd2.service.patient;

import com.it_academy.jd2.model.patient.Diagnosis;
import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.patient.enums.HealthStatus;
import com.it_academy.jd2.service.api.patient.IDiagnosisService;
import com.it_academy.jd2.storage.api.medicalCard.IDiagnosisRepository;

import java.util.List;

public class DiagnosisService implements IDiagnosisService {
    private IDiagnosisRepository repository;

    public DiagnosisService(IDiagnosisRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Diagnosis> getAllByCard(MedicalСard card) {
        return this.repository.findAllByCard(card);
    }

    @Override
    public Diagnosis getStatusDiagnosis(MedicalСard card, HealthStatus status) {
        return this.repository.findFirstByHealthStatusAndCard(status,card);
    }

    @Override
    public Diagnosis savaDiagnosis(Diagnosis diagnosis) {
        return this.repository.save(diagnosis);
    }
}
