package com.ashiq.contactbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashiq.contactbook.entity.User;
import com.ashiq.contactbook.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User addUser(User user) {
		return userRepo.save(user);
	}

	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
//	public List<User> searchByFirstAndOrLastName(@Param("f_name") String f_name, @Param("l_name") String l_name) {
//		return userRepo.searchByFirstAndOrl_name(f_name, l_name);
//	}

	public String deleteUser(int id) {
		boolean isExisting = userRepo.existsById(id);
		if (isExisting) {
			userRepo.deleteById(id);
			return "User removed !! " + id;
		} else {
			return "No user found with this id : " + id;
		}
	}

	public User updateUser(User user) {
		User existingUser = userRepo.findById(user.getUser_id()).orElse(null);
		existingUser.setF_name(user.getF_name());
		existingUser.setL_name(user.getL_name());
		existingUser.setEmail_personal(user.getEmail_personal());
		existingUser.setNote(user.getNote());
		existingUser.setGender(user.getGender());
		existingUser.setDob(user.getDob());
		existingUser.setImg(user.getImg());
		
		return userRepo.save(existingUser);
	}
}
