package com.ashiq.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashiq.contactbook.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
