package com.ustg.springapp.controller;

import com.ustg.springapp.model.Student;
import com.ustg.springapp.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{branchId}/student")
    public ResponseEntity<?> addStudent(@PathVariable Long branchId, @RequestBody Student student){
        student = studentService.addStudent(branchId,student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @GetMapping
    public ResponseEntity<?> getAllBranches(){
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getBranch(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateBranch(@PathVariable Long id,@RequestBody Student student){
        Student student2 = studentService.updateStudent(id,student);
        if(student2 == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(student2);
        }
    }


    @DeleteMapping("/student")
    public ResponseEntity<?> deleteBranch(@RequestParam Long id){
        if(studentService.deleteStudent(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student not found");
        }
    }
}
