package com.ustg.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.springapp.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
