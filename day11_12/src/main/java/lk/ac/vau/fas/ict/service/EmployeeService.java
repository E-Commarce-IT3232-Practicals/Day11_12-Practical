package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.ict.model.Employee;
import lk.ac.vau.fas.ict.repo.EmployeeRepo;

@Service
public class EmployeeService {
    
    @Autowired
    public EmployeeRepo employeeRepository;

    //find the employees with the salary range 70000 to 90000
    public List<Employee> getEmployeesbetweenSalary(int s,int e) {
        return employeeRepository.findSalaryRange(s, e);
    }
}