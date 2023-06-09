package com.ashiq.contactbook.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashiq.contactbook.entity.Gender;
import com.ashiq.contactbook.entity.Phone;
import com.ashiq.contactbook.entity.User;
import com.ashiq.contactbook.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userRepo.findAll(), HttpStatus.FOUND);
	}

	public ResponseEntity<User> getUserById(int id) {
		boolean isExisting = userRepo.existsById(id);
		if (isExisting) {
			User foundUser = userRepo.findById(id).orElse(null);
			return new ResponseEntity<User>(foundUser, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<User> addUser(User user) {
		return new ResponseEntity<User>(userRepo.save(user), HttpStatus.CREATED);
	}

	public ResponseEntity<User> deleteUser(int id) {
		boolean isExisting = userRepo.existsById(id);
		if (isExisting) {
			userRepo.deleteById(id);
			return new ResponseEntity<User>(HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	public ResponseEntity<User> updateUser(User user) {
		User existingUser = userRepo.findById(user.getUser_id()).orElse(null);
		if (existingUser == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			existingUser.setF_name(user.getF_name());
			existingUser.setL_name(user.getL_name());
			existingUser.setEmail_personal(user.getEmail_personal());
			existingUser.setNote(user.getNote());
			existingUser.setGender(user.getGender());
			existingUser.setDob(user.getDob());
			existingUser.setImg(user.getImg());

			return new ResponseEntity<User>(userRepo.save(existingUser), HttpStatus.OK);
		}
	}

	public ResponseEntity<List<User>> getUsersByGender(Gender gender) {
		return new ResponseEntity<List<User>>(userRepo.getUsersByGender(gender), HttpStatus.FOUND);
	}
	
	public ResponseEntity<List<User>> getUserDobLimit(LocalDate date) {
		return new ResponseEntity<List<User>>(userRepo.getUserDobLimit(date), HttpStatus.FOUND);
	}
}
