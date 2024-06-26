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
import org.springframework.web.bind.annotation.RestController;

import com.ustg.springapp.model.Department;
import com.ustg.springapp.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment(){
		return ResponseEntity.ok().body(departmentService.getAllDepartments());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
		Department department=departmentService.getDepartment(id);
		if(department==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(department);
		
	}
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department d){
		Department department=departmentService.createDepartment(d);
		return ResponseEntity.ok().body(department);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable Long id,@RequestBody Department d){
		Department department=departmentService.getDepartment(id);
		if(department==null) {
			return ResponseEntity.noContent().build();
		}else {
			Department dep=departmentService.updateDepartment(id, d);
		return ResponseEntity.ok().body(dep);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
		Department department=departmentService.getDepartment(id);
		if(department==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(departmentService.deleteDepartment(id));
		
	}

}
