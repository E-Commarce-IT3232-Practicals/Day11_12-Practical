package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Employee;
import lk.ac.vau.fas.ict.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/salary/{a}/{b}")
	public ResponseEntity<List<Employee>>searchBySalary(@PathVariable("a") int s,@PathVariable("b") int e){
		return new ResponseEntity<List<Employee>>
		(employeeService.getEmployeesbetweenSalary(s, e),HttpStatus.OK);
	}
}
