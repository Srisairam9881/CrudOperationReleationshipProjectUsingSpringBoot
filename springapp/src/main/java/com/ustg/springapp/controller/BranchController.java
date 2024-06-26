package com.ustg.springapp.controller;

import com.ustg.springapp.model.Branch;
import com.ustg.springapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<?> addBranch(@RequestBody Branch branch){
        Branch retBranch = branchService.addBranch(branch);
        return ResponseEntity.status(HttpStatus.CREATED).body(retBranch);
    }

    @GetMapping
    public ResponseEntity<?> getAllBranches(){
        List<Branch> list = branchService.getAllBranches();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<?> getBranch(@PathVariable Long branchId){
        Branch branch = branchService.getBranchById(branchId);
        if(branch == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Branch not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(branch);
        }
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<?> updateBranch(@PathVariable Long branchId,@RequestBody Branch branch){
        Branch retVal = branchService.updateBranch(branchId,branch);
        if(retVal == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Branch not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(retVal);
        }
    }


    @DeleteMapping
    public ResponseEntity<?> deleteBranch(@RequestParam Long branchId){
        if(branchService.deleteBranch(branchId)) {
            return ResponseEntity.status(HttpStatus.OK).body("Branch deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Branch not found");
        }
    }
}
