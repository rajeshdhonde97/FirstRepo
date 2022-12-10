
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import com.example.demo.serviceImpl.StudentImpl;

@RestController
@RequestMapping("/stud")
public class StudentController {

	@Autowired
	private StudentImpl studentImpl;
	
	@Autowired
	private StudentDao studentDao;
	

	@PostMapping("/save")
	public ResponseEntity<Student> SaveStudentData(@RequestBody Student student) {

		Student st = studentImpl.SaveStudentData(student);
		return ResponseEntity.ok().body(st);

	}

	@GetMapping
	public List<Student> getStudentDetails() {
		return studentImpl.getStudentDetails();

	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudentData(@PathVariable("id") int id, @RequestBody Student student) {
		Student s = studentImpl.updateStudentData(student, id);
		return ResponseEntity.ok().body(s);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Student> deleteStudentData(@PathVariable("id") int id) {

		Student s1 = studentImpl.deleteStudentData(id);
		return ResponseEntity.ok().body(s1);
	}
	
	
	  @GetMapping("{id}") 
	  public Optional<Student> getStudentDataById(@PathVariable("id") int id){   
	  return studentDao.findById(id);
	  }
	  
		
}

