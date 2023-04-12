package com.ashiq.contactbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashiq.contactbook.entity.Phone;
import com.ashiq.contactbook.entity.Student;
import com.ashiq.contactbook.entity.User;
import com.ashiq.contactbook.repository.PhoneRepo;
import com.ashiq.contactbook.service.PhoneService;
import com.ashiq.contactbook.service.StudentService;
import com.ashiq.contactbook.service.UserService;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private PhoneService phoneService;

	@Autowired
	private UserService userService;

	/* Student */

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		System.out.println(student);
		return studentService.saveStudent(student);
	}

	/* Phone */
	
	@PostMapping("phone")
	public ResponseEntity<Phone> addPhone(@RequestBody Phone phone){
		return new ResponseEntity<Phone>(phoneService.addPhone(phone), HttpStatus.CREATED);
	}
	
	@GetMapping("/phones")
	public List<Phone> getAllPhoneNumber() {
		return phoneService.getAllPhoneNumber();
	}

	@GetMapping("/phone/{id}")
	public Optional<Phone> getPhoneById(@PathVariable("id") int id) {
		return phoneService.getPhoneById(id);
	}
	
	@PutMapping("/phone")
	public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone){
		return new ResponseEntity<>(phoneService.updatePhone(phone), HttpStatus.OK);
	}
	
	@DeleteMapping("phone/{id}")
	public String deletePhone(@PathVariable("id") int id) {
		return phoneService.deletePhone(id);
	}
	
	/* User */

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
//	@GetMapping("user/{f_nameorl_name}")
//	public List<User> searchByFirstAndOrl_name(@Param("f_name") String f_name, @Param("l_name")  String l_name){
//		return userService.searchByFirstAndOrLastName(f_name, l_name);
//	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}
}
