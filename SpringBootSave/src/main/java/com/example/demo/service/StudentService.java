package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
	//Save Student Data in Database
	public Student SaveStudentData(Student student);
	
	//fetch All the Student Data
	public List<Student> getStudentDetails();
	
	//Update Student Data
	public Student updateStudentData(Student student, int id);
	
	//Delete Student Data
	public Student deleteStudentData(int id);
	
	//Fetch Data by using Id
	public Student getStudentDataById(int id);
	
	//Fetch Data by using Name
   // public Student getStudentFindByName(String firstname);
    
   
}
