package com.it_academy.jd2.service.patient;

import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.patient.IMedicalCardService;
import com.it_academy.jd2.storage.api.medicalCard.IMedicalCardRepository;

import java.util.Set;
import java.util.TreeSet;

public class MedicalCardService implements IMedicalCardService {

    private IMedicalCardRepository medicalNoteRepository;

    public MedicalCardService() {
    }

    public MedicalCardService(IMedicalCardRepository medicalNoteRepository) {
        this.medicalNoteRepository = medicalNoteRepository;
    }

    @Override
    public MedicalСard addMedicalСard(MedicalСard medicalNote) {
        return medicalNoteRepository.save(medicalNote);
    }

    @Override
    public Set<MedicalСard> getNotesByUser(User user) {
        return medicalNoteRepository.findAllByUser(user);
    }


    @Override
    public Set<MedicalСard> getAll() {
        return medicalNoteRepository.findAllByOrderByDateAsc();
    }

    @Override
    public MedicalСard getNoteById(int id) {
        return medicalNoteRepository.findById(id);
    }

    @Override
    public boolean update(MedicalСard medicalNote, int id) {
        MedicalСard noteNew = medicalNoteRepository.findById(id);
        noteNew.setDescription(medicalNote.getDescription());
        noteNew.setName(medicalNote.getName());
        noteNew.setType(medicalNote.getType());
        noteNew.setIllness(medicalNote.getIllness());
        noteNew.setDate(medicalNote.getDate());
        noteNew.setId(medicalNote.getId());
        MedicalСard noteSaved = medicalNoteRepository.save(noteNew);
        if (noteSaved.equals(noteNew)) {
            return true;
        } else return false;
    }

    @Override
    public boolean delete(int id) {
        MedicalСard medicalNote = medicalNoteRepository.findById(id);
        if (medicalNote == null) {
            return false;
        } else {
            medicalNoteRepository.delete(medicalNote);
            return true;
        }
    }

    @Override
    public TreeSet<MedicalСard> getAllByUserId(int id) {
        return medicalNoteRepository.findAllByUserId(id);
    }

}
