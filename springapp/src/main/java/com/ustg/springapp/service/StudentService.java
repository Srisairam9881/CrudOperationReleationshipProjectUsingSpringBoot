package com.ustg.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.springapp.model.Branch;
import com.ustg.springapp.model.Student;
import com.ustg.springapp.repository.BranchRepository;
import com.ustg.springapp.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    private BranchRepository branchRepository;

    @Autowired
    private StudentRepository studentRepository;

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
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        if(studentRepository.existsById(id)){
            return studentRepository.findById(id).get();
        }else{
            return null;
        }
    }

    public Student updateStudent(Long id, Student student){
        if(studentRepository.existsById(id)){
            student.setStudentId(id);
            return studentRepository.save(student);
        }else{
            return null;
        }
    }

    public boolean deleteStudent(Long branchId){
        if(studentRepository.existsById(branchId)){
        	studentRepository.deleteById(branchId);
            return true;
        }else{
            return false;
        }
    }
}
