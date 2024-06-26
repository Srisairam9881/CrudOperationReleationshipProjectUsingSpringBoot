package com.ustg.springapp.collegeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.springapp.collegeModel.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long>{
	
}
