package com.ustg.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.springapp.model.Department;
import com.ustg.springapp.model.Employee;
import com.ustg.springapp.repository.DepartmentRepository;
import com.ustg.springapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Employee creaEmployee(Long depId,Employee employee) {
		Optional<Department> d=departmentRepository.findById(depId);
		if(d.isPresent()) {
			Department dep=d.get();
			employee=employeeRepository.save(employee);
			dep.getEmployee().add(employee);
			departmentRepository.save(dep);
		}
		return null;
	}
	public List<Employee> gettAlEmployees(){
		return employeeRepository.findAll();
	}
	public Employee getEmployeeById(Long id){
		Employee emp=employeeRepository.findById(id).get();
		return emp;
	}
	public Employee updateEmployee(Long id,Employee employee){
		Employee emp=employeeRepository.findById(id).get();
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setAge(employee.getAge());
		emp.setSalary(employee.getSalary());
		return emp;
	}
	public boolean DeleteEmployee(Long id){
		Employee emp=employeeRepository.findById(id).get();
		if(emp!=null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
