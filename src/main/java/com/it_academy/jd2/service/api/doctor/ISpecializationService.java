package com.it_academy.jd2.service.api.doctor;

import com.it_academy.jd2.model.doctor.Specialization;
import java.util.List;

public interface ISpecializationService {
    List<Specialization> getAll();
    Specialization getById(int id);
    boolean update(Specialization specialization, int id);
    Specialization getByName(String name);
    Specialization add(Specialization specialization);
    boolean delete(int id);
}
