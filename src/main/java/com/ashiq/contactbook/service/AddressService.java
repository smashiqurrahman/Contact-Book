package com.ashiq.contactbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ashiq.contactbook.entity.Address;
import com.ashiq.contactbook.entity.Occupation;
import com.ashiq.contactbook.repository.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;

	public List<Address> getAllAddresses() {
		return addressRepo.findAll();
	}

	public Optional<Address> getAddressById(int id) {
		return addressRepo.findById(id);
	}

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public ResponseEntity<Address> updateAddress(Address address) {
		Address existingAddress = addressRepo.findById(address.getId()).orElse(null);
		if (existingAddress == null) {
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		} else {
			existingAddress.setAddress_line(address.getAddress_line());
			existingAddress.setCity(address.getCity());
			existingAddress.setState(address.getState());
			existingAddress.setCountry(address.getCountry());
			existingAddress.setPostal(address.getPostal());
			existingAddress.setLatitude(address.getLatitude());
			existingAddress.setLongitude(address.getLongitude());

			return new ResponseEntity<Address>(addressRepo.save(existingAddress), HttpStatus.OK);
		}
	}

	public String deleteAddress(int id) {
		boolean isExisting = addressRepo.existsById(id);
		if (isExisting) {
			addressRepo.deleteById(id);
			return "Address removed !! " + id;
		} else {
			return "No Address number found with this id : " + id;
		}
	}
}
