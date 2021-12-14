package com.it_academy.jd2.service.patient;

import com.it_academy.jd2.model.doctor.Department;
import com.it_academy.jd2.service.api.doctor.IDepartmentService;
import com.it_academy.jd2.storage.api.people.IDepartmentRepository;

import java.util.List;

public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean update(Department department, int id) {
        Department departmentNew = departmentRepository.findById(id);
        departmentNew.setDescription(department.getDescription());
        Department departmentSaved = departmentRepository.save(departmentNew);
        if(departmentSaved.equals(departmentNew)){
            return true;
        } else return false;
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean delete(int id) {
        Department department = departmentRepository.findById(id);
        if(department == null){
            return false;
        } else {
            departmentRepository.delete(department);
            return true;
        }
    }
}
