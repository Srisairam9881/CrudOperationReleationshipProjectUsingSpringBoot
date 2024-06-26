package com.ustg.springapp.collegeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.springapp.collegeModel.College;
import com.ustg.springapp.collegeModel.Students;
import com.ustg.springapp.collegeRepo.CollegeRepo;
import com.ustg.springapp.collegeRepo.StudentRepo;

@Service
public class CollegeService {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private CollegeRepo collegeRepo;
	
	public College createCollege(College college) {
		return collegeRepo.save(college);		
	}
	public List<College> getAllColleges(){
		List<College> colleges= collegeRepo.findAll();
		return colleges;
	}
	public Students createStudent(Long collegeId,Students students) {
		if(collegeRepo.existsById(collegeId)) {
			College college=collegeRepo.findById(collegeId).get();
			students=studentRepo.save(students);
			college.getStudents().add(students);
			collegeRepo.save(college);
			return students;
		}else {
		return null;
		}
	}
	  public List<Students> getStudentsByCollegeName(String collegeName) {
	        College college = collegeRepo.findByCollegeName(collegeName);
	        if (college != null) {
	            return college.getStudents();
	        } else {
	            return new ArrayList<>();
	        }
	    }

}
