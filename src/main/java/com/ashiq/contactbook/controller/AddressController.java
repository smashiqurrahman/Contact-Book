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

import com.ashiq.contactbook.entity.Address;
import com.ashiq.contactbook.service.AddressService;

@RestController
@RequestMapping("/api/address-api/")
public class AddressController {
	@Autowired
	private AddressService addressService;


	@PostMapping("/address")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@PutMapping("/address")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}

	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAllAddresses() {
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


}
