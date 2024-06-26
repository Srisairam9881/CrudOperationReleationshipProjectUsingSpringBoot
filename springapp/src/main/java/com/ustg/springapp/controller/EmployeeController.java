package com.ustg.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

