package com.ashiq.contactbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashiq.contactbook.entity.Student;
import com.ashiq.contactbook.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
}
