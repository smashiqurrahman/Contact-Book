package com.ashiq.contactbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashiq.contactbook.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

//	@Query("select u from user u where (:f_name is null or u.f_name = :f_name)"
//		      +" and (:l_name is null or u.l_name = :l_name)")
//		List<User> searchByFirstAndOrl_name(@Param("f_name") String f_name,
//		                                              @Param("l_name") String l_name);
		    
}
