package com.ustg.springapp.collegeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.springapp.collegeModel.College;
import com.ustg.springapp.collegeModel.Students;
import com.ustg.springapp.collegeService.CollegeService;

@RestController
public class collegeController {
    @Autowired
    private CollegeService collegeService;
    
    @PostMapping("/colleges")
    public ResponseEntity<College> createCollege(@RequestBody College college)
    {
    	College col=collegeService.createCollege(college);
    	return ResponseEntity.ok().body(col);
    }
    @PostMapping("/colleges/{CollegeId}/students")
    public ResponseEntity<Students> createStudent(@PathVariable Long CollegeId,@RequestBody Students students)
    {
    	Students stu=collegeService.createStudent(CollegeId,students);
    	if (stu != null) {
            return ResponseEntity.ok().body(stu);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllCollegs()
    {
    	List<College> colleges=collegeService.getAllColleges();
    	return ResponseEntity.ok().body(colleges);
    }
    
    @GetMapping("/colleges/students")
    public ResponseEntity<List<Students>> getStudentsByCollegeName(@RequestParam String collegeName) {
        List<Students> students = collegeService.getStudentsByCollegeName(collegeName);
        if (!students.isEmpty()) {
            return ResponseEntity.ok().body(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
