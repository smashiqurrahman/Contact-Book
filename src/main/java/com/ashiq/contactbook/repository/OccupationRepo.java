package com.ashiq.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashiq.contactbook.entity.Occupation;

public interface OccupationRepo extends JpaRepository<Occupation, Integer>{

}
