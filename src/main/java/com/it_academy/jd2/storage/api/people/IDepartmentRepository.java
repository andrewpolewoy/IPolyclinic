package com.it_academy.jd2.storage.api.people;

import com.it_academy.jd2.model.doctor.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    Department findById(int id);
    Department findByName(String name);
}
