package com.ashiq.contactbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Phone updatePhone(Phone phone) {
		Phone existingPhone = phoneRepo.findById(phone.getId()).orElse(null);
		existingPhone.setPhone(phone.getPhone());
		existingPhone.setType(phone.getType());

		return phoneRepo.save(existingPhone);
	}

	public String deletePhone(int id) {
		boolean isExisting = phoneRepo.existsById(id);
		
		if(isExisting) {
			phoneRepo.deleteById(id);
			return "Phone removed !! " + id;
		}else {
			return "No phone number found with this id : " + id;
		}
	}
}
