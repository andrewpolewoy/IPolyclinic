package com.it_academy.jd2.storage.api.people;

import com.it_academy.jd2.model.doctor.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpecializationRepository extends JpaRepository<Specialization, Integer> {

    Specialization findById(int id);
    Specialization findByName(String name);
}
