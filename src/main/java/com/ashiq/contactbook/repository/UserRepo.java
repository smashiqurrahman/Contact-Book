package com.ashiq.contactbook.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashiq.contactbook.entity.Gender;
import com.ashiq.contactbook.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	/* JPQL */
	@Query("SELECT u from User u WHERE u.gender = :n")
	public List<User> getUsersByGender(@Param("n") Gender n);
	
	/* Native Query */
	@Query(value = "select * from user u where u.dob < ?1", nativeQuery = true)
	public List<User> getUserDobLimit(@Param("date") LocalDate date); 
}
