package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student SaveStudentData(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public List<Student> getStudentDetails() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public Student updateStudentData(Student student, int id) {
		// TODO Auto-generated method stub
		Student s=studentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		
		s.setFirstname(student.getFirstname());
		s.setSalary(student.getSalary());
		studentDao.save(s);
		return null;
	}

	@Override
	public Student deleteStudentData(int id) {
		// TODO Auto-generated method stub
		studentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentDao.deleteById(id);
		return null;
	}


	  @Override
	  public Student getStudentDataById(int id) {
		  // TODO Auto-generate method stub 
		  studentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id)); 
		  studentDao.findById(id);
	      return null;
	  
	  }


	  
	  

}
