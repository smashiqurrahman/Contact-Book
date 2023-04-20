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

	public ResponseEntity<List<Phone>> getAllPhoneNumber() {
		return new ResponseEntity<List<Phone>>(phoneRepo.findAll(), HttpStatus.FOUND);
	}

	public ResponseEntity<Phone> getPhoneById(int id) {
		boolean isExisting = phoneRepo.existsById(id);
		if (isExisting) {			
			Phone foundPhone = phoneRepo.findById(id).orElse(null);
			return new ResponseEntity<Phone>(foundPhone, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Phone> addPhone(Phone phone) {
		return new ResponseEntity<Phone>(phoneRepo.save(phone), HttpStatus.CREATED);
	}

	public ResponseEntity<Phone> deletePhone(int id) {
		boolean isExisting = phoneRepo.existsById(id);

		if (isExisting) {
			phoneRepo.deleteById(id);
			return new ResponseEntity<Phone>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
		}
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

}
