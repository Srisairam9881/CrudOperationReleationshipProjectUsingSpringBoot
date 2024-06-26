package com.ustg.springapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long branchId;
    private String branchName;

    @OneToMany
    List<Student> studentList = new ArrayList<>();


    public Branch() {
        this(0L,"");
    }

    public Branch(Long branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
