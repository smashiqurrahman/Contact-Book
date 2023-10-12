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

import com.ashiq.contactbook.entity.Occupation;
import com.ashiq.contactbook.service.OccupationService;

@RestController
@RequestMapping("/api/occupation-api/")
public class OccupationController {

	@Autowired
	private OccupationService occupationService;
	
	
	@PostMapping("/occupation")
	public ResponseEntity<Occupation> saveOccupation(@RequestBody Occupation occupation) {
		return occupationService.saveOccupation(occupation);
	}

	@PutMapping("/occupation")
	public ResponseEntity<Occupation> updateOccupation(@RequestBody Occupation occupation) {
		return occupationService.updateOccupation(occupation);
	}

	@GetMapping("/occupations")
	public ResponseEntity<List<Occupation>> getAllOccupation() {
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
}
