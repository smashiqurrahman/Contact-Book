package com.ashiq.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashiq.contactbook.entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone, Integer>{

}
