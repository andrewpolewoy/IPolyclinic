package com.it_academy.jd2.service.api.patient;

import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.user.User;

import java.util.Set;
import java.util.TreeSet;

public interface IMedicalCardService {
    ////    List<MedicalСard>  findAllDoctorsForPatient(User user);
////    List<MedicalСard> findAllPatientsForDoctor(User user);
//    MedicalСard addMedicalСard(MedicalСard medicalСard);
//
//    MedicalСard findMedicalCardById(Integer id);
//    List<MedicalСard> findMedicalCardForCard(User doctor, User patient, String diagnosis);
////    MedicalСard saveMedicalCard(User doctor, User patient, String diagnosis);
//    TreeSet<MedicalСard> getAllByUserId(int id);
//    boolean update(MedicalСard medicalNote, int id);
//    boolean delete(int id);
    MedicalСard addMedicalСard(MedicalСard medicalNote);
    Set<MedicalСard> getNotesByUser(User user);
    Set<MedicalСard> getAll();
    MedicalСard getNoteById(int id);
    boolean update(MedicalСard medicalNote, int id);
    boolean delete(int id);
    TreeSet<MedicalСard> getAllByUserId(int id);

}
