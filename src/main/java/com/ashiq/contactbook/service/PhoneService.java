package com.ashiq.contactbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ashiq.contactbook.entity.Address;
import com.ashiq.contactbook.entity.Phone;
import com.ashiq.contactbook.repository.PhoneRepo;

@Service
public class PhoneService {

	@Autowired
	PhoneRepo phoneRepo;

	public Phone addPhone(Phone phone) {	
		return phoneRepo.save(phone);
	}

	public List<Phone> getAllPhoneNumber() {
		return phoneRepo.findAll();
	}

	public Optional<Phone> getPhoneById(int id) {
		return phoneRepo.findById(id);
	}

	public ResponseEntity<Phone> updatePhone(Phone phone) {
		Phone existingPhone = phoneRepo.findById(phone.getId()).orElse(null);
		if (existingPhone == null) {
			return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
		} else {
			existingPhone.setPhone(phone.getPhone());
			existingPhone.setType(phone.getType());

			return new ResponseEntity<Phone>(phoneRepo.save(existingPhone), HttpStatus.OK);
		}
	}

	public String deletePhone(int id) {
		boolean isExisting = phoneRepo.existsById(id);

		if (isExisting) {
			phoneRepo.deleteById(id);
			return "Phone removed !! " + id;
		} else {
			return "No phone number found with this id : " + id;
		}
	}
}
