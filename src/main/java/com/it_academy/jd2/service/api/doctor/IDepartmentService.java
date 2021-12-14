package com.it_academy.jd2.service.api.doctor;

import com.it_academy.jd2.model.doctor.Department;
import java.util.List;

public interface IDepartmentService {
    List<Department> getAll();
    Department getById(int id);
    boolean update(Department department, int id);
    Department getByName(String name);
    Department add(Department department);
    boolean delete(int id);
}
