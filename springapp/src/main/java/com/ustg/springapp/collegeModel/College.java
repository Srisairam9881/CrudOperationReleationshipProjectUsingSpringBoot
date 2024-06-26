package com.ustg.springapp.collegeModel;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long collegeId;
	private String collegeName;
	
	@OneToMany
	private List<Students> students=new ArrayList<Students>();

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

}
