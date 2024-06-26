package com.ustg.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.springapp.model.Department;
import com.ustg.springapp.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	public Department updateDepartment(Long id,Department department) {
		Optional<Department> d=departmentRepository.findById(id);
		if(d.isPresent()) {
			Department dep=d.get();
			dep.setId(id);
			dep.setDepartmentName(department.getDepartmentName());
			departmentRepository.save(dep);
		}
		return null;
	}
	public Department getDepartment(Long id) {
		Optional<Department> d=departmentRepository.findById(id);
		if(d.isPresent()) {
			Department dep=d.get();
			return dep;
		}
		return null;
	}
	public boolean deleteDepartment(Long id) {
		if(departmentRepository.existsById(id)) {
			 departmentRepository.deleteById(id);
			 return true;
		}
		return false;
	}
	

}
