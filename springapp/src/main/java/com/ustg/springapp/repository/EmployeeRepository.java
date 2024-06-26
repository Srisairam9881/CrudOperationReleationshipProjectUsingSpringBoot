package com.ustg.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ustg.springapp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

