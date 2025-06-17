package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.model.ViewDepartment;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;


@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepo departmentRepository;

    //Get All departments
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    //Get Department by ID
    public Department getDepartmentById(int id){
        if (departmentRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Department Not Found");
        }
        return departmentRepository.findById(id).get();
    }

    //Add new Department
    public String addDepartment(Department department) {
        if (departmentRepository.findById(department.getId()).isPresent()) {
            throw new DuplicateKeyException("The department id is already available!");
        }

        departmentRepository.save(department);
        return "New Department has been added";
    }

    //Get Departments Names
    public List<String> getDepartmentNames(){
        if(departmentRepository.getDepartmentNames().isEmpty()) {
            throw new EntityNotFoundException("Departments Not Found");
        }
        return departmentRepository.getDepartmentNames();
    }

    //Search Departments by name
    public List<Department> searchDepartments(String name){
        return departmentRepository.searchName(name);
    }

    //Display the count of employee belongs to given department id
    public Integer getEmployeeCount(int id) {
        return departmentRepository.numberOfEmp(id);
    }

    //Display the count of employee along with department details
    public ViewDepartment getEmpCount(int id) {
        if (departmentRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Department Not FOund");
        }
        Department department = departmentRepository.findById(id).get();
        ViewDepartment viewDepartment = new ViewDepartment(department.getId(), department.getName(),
				department.getEstablished(), getEmployeeCount(id));
        return viewDepartment;
    }
}