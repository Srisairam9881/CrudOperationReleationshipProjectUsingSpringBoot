package com.ustg.springapp.controller;

import com.ustg.springapp.model.Student;
import com.ustg.springapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
public class StudentController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/{branchId}/student")
    public ResponseEntity<?> addStudent(@PathVariable Long branchId, @RequestBody Student student){
        student = branchService.addStudent(branchId,student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
