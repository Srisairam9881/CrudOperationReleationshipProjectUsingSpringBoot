package com.ustg.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.springapp.model.Employee;
import com.ustg.springapp.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/{depId}")
	public ResponseEntity<?> createeEmployee(@PathVariable Long depId,@RequestBody Employee employee){
		return ResponseEntity.ok().body(employeeService.creaEmployee(depId, employee));
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok().body(employeeService.gettAlEmployees());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Employee employee){
		return ResponseEntity.ok().body(employeeService.updateEmployee(id, employee));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
		return ResponseEntity.ok().body(employeeService.DeleteEmployee(id));
	}
	

}

