package com.ashiq.contactbook.controller;

import java.util.List;

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

import com.ashiq.contactbook.entity.Phone;
import com.ashiq.contactbook.service.PhoneService;

@RestController
@RequestMapping("/api/phone-api/")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;
	
	@PostMapping("phone")
	public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
		return phoneService.addPhone(phone);
	}

	@PutMapping("/phone")
	public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
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

}
