package com.ashiq.contactbook.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ashiq.contactbook.entity.Gender;
import com.ashiq.contactbook.entity.User;
import com.ashiq.contactbook.service.UserService;

@RestController
@RequestMapping("/api/user-api/")
public class UserController {

	@Autowired
	private UserService userService;
	
	
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

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/user/getuserbygender/{gender}")
	public ResponseEntity<List<User>> getUserByGender(@PathVariable("gender") Gender gender) {
		return userService.getUsersByGender(gender);
	}

	@GetMapping("/user/getuserdoblimit")
	public ResponseEntity<List<User>> getUserDobLimit(@RequestParam("date") String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.US); // Locale specifies human language for translating, and cultural
														// norms for lowercase/uppercase and abbreviations and such.
														// Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate dateFormatted = LocalDate.parse(date, formatter);

		return userService.getUserDobLimit(dateFormatted);
	}
}
