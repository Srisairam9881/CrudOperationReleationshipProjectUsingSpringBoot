package com.ustg.springapp.collegeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.springapp.collegeModel.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long>{
	College findByCollegeName(String collegeName);

}
