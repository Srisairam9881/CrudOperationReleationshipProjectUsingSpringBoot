package com.ustg.springapp.collegeModel;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String courseTaken;
	private int marks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(String courseTaken) {
		this.courseTaken = courseTaken;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	

}
