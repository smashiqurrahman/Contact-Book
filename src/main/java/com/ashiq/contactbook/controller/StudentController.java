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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashiq.contactbook.entity.Address;
import com.ashiq.contactbook.entity.Occupation;
import com.ashiq.contactbook.entity.Phone;
import com.ashiq.contactbook.entity.Student;
import com.ashiq.contactbook.entity.User;
import com.ashiq.contactbook.repository.PhoneRepo;
import com.ashiq.contactbook.service.AddressService;
import com.ashiq.contactbook.service.OccupationService;
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

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private OccupationService occupationService;
	
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

	/* Address */
	
	@PostMapping("/address")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		return addressService.saveAddress(address);
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		return addressService.updateAddress(address);
	}
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAllAddresses(){
		return addressService.getAllAddresses();
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") int id) {
		return addressService.getAddressById(id);
	}
		
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") int id) {
		return addressService.deleteAddress(id);
	}
	
	/* OccupationInfo */
	@PostMapping("/occupation")
	public ResponseEntity<Occupation> saveOccupation(@RequestBody Occupation occupation){
		return occupationService.saveOccupation(occupation);
	}
	
	@PutMapping("/occupation")
	public ResponseEntity<Occupation> updateOccupation(@RequestBody Occupation occupation){
		return occupationService.updateOccupation(occupation);
	}	
	
	@GetMapping("/occupations")
	public ResponseEntity<List<Occupation>> getAllOccupation(){
		return occupationService.getAllOccupation();
	}
	
	@GetMapping("/occupation/{id}")
	public ResponseEntity<Occupation> getOccupationById(@PathVariable("id") int id) {
		return occupationService.getOccupationById(id);
	}
	
	@DeleteMapping("occupation/{id}")
	public ResponseEntity<Occupation> deleteOccupation(@PathVariable("id") int id) {
		return occupationService.deleteOccupation(id);
	}
	
		
	/* Phone */
	
	@PostMapping("phone")
	public ResponseEntity<Phone> addPhone(@RequestBody Phone phone){
		return phoneService.addPhone(phone);
	}
	
	@PutMapping("/phone")
	public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone){
		return phoneService.updatePhone(phone);
	}
	
	@GetMapping("/phones")
	public ResponseEntity<List<Phone>> getAllPhoneNumber() {
		return phoneService.getAllPhoneNumber();
	}

	@GetMapping("/phone/{id}")
	public ResponseEntity<Phone> getPhoneById(@PathVariable("id") int id) {
		return phoneService.getPhoneById(id);
	}
	
	@DeleteMapping("phone/{id}")
	public ResponseEntity<Phone> deletePhone(@PathVariable("id") int id) {
		return phoneService.deletePhone(id);
	}
	
	/* User */

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
//	@GetMapping("user/{f_nameorl_name}")
//	public List<User> searchByFirstAndOrl_name(@Param("f_name") String f_name, @Param("l_name")  String l_name){
//		return userService.searchByFirstAndOrLastName(f_name, l_name);
//	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}
}
