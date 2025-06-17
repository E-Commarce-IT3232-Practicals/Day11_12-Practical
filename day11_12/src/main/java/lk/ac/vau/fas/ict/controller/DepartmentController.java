package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.model.ViewDepartment;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;
import lk.ac.vau.fas.ict.service.DepartmentService;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    public DepartmentRepo departmentRepository;

    @Autowired
    public DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<List<Department>>
        (departmentService.getAllDepartments(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {
        return  new ResponseEntity<Department>
        (departmentService.getDepartmentById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNewDepartment(@RequestBody Department department) {
        return new ResponseEntity<String>(departmentService.addDepartment(department),HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getDepartmentNames(){
        return new ResponseEntity<List<String>>(departmentService.getDepartmentNames(),HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Department>> searchDepartmentByName(@PathVariable("name") String name){
        return new ResponseEntity<List<Department>>(departmentService.searchDepartments(name),HttpStatus.OK);
    }

    @GetMapping("/count/{dept_id}")
    public ResponseEntity<Integer> getEmployeeCount(@PathVariable("dept_id") Integer dept_id) {
        return new ResponseEntity<Integer>(departmentService.getEmployeeCount(dept_id),HttpStatus.OK);
    }

    @GetMapping("/view/count/{id}")
	public ResponseEntity<ViewDepartment> vcountEmp(@PathVariable("id") int id) {
		return new ResponseEntity<ViewDepartment>(departmentService.getEmpCount(id),HttpStatus.OK);
	}
}
