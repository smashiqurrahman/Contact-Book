package com.ashiq.contactbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ashiq.contactbook.entity.Occupation;
import com.ashiq.contactbook.repository.OccupationRepo;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@Service
public class OccupationService {

	@Autowired
	private OccupationRepo occupationRepo;

	public ResponseEntity<List<Occupation>> getAllOccupation() {
		return new ResponseEntity<List<Occupation>>(occupationRepo.findAll(), HttpStatus.FOUND);
	}

	public ResponseEntity<Occupation> getOccupationById(int id) {
		boolean isExisting = occupationRepo.existsById(id);
		if (isExisting) {			
			Occupation foundOccupation = occupationRepo.findById(id).orElse(null);
			return new ResponseEntity<Occupation>(foundOccupation, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Occupation>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Occupation> saveOccupation(Occupation occupation) {		
		return new ResponseEntity<Occupation>(occupationRepo.save(occupation), HttpStatus.CREATED);
	}

	public ResponseEntity<Occupation> deleteOccupation(int id) {
		boolean isExisting = occupationRepo.existsById(id);
		if (isExisting) {			
			occupationRepo.deleteById(id);
			return new ResponseEntity<Occupation>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Occupation>(HttpStatus.NO_CONTENT);
		}
	}

	public ResponseEntity<Occupation> updateOccupation(Occupation occupation) {
		Occupation existingOccupation = occupationRepo.findById(occupation.getId()).orElse(null);
		if (existingOccupation == null) {
			return new ResponseEntity<Occupation>(HttpStatus.NO_CONTENT);
		} else {
			existingOccupation.setProfession(occupation.getProfession());
			existingOccupation.setJob_title(occupation.getJob_title());
			existingOccupation.setCompanyName(occupation.getCompanyName());
			existingOccupation.setNote(occupation.getNote());
			existingOccupation.setEmailWork(occupation.getEmailWork());
			return new ResponseEntity<Occupation>(occupationRepo.save(existingOccupation), HttpStatus.OK);
		}
	}
}
