package com.ustg.springapp.service;

import com.ustg.springapp.model.Branch;
import com.ustg.springapp.model.Student;
import com.ustg.springapp.repository.BranchRepository;
import com.ustg.springapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Branch addBranch(Branch branch){
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }

    public Branch getBranchById(Long branchId){
        if(branchRepository.existsById(branchId)){
            return branchRepository.findById(branchId).get();
        }else{
            return null;
        }
    }

    public Branch updateBranch(Long branchId, Branch branch){
        if(branchRepository.existsById(branchId)){
            branch.setBranchId(branchId);
            return branchRepository.save(branch);
        }else{
            return null;
        }
    }

    public boolean deleteBranch(Long branchId){
        if(branchRepository.existsById(branchId)){
            branchRepository.deleteById(branchId);
            return true;
        }else{
            return false;
        }
    }


    public Student addStudent(Long branchId, Student student){
        if(branchRepository.existsById(branchId)){
            Branch branch = branchRepository.findById(branchId).get();
            student = studentRepository.save(student);

            branch.getStudentList().add(student);
            branchRepository.save(branch);
            return student;
        }else{
            return null;
        }
    }
}
