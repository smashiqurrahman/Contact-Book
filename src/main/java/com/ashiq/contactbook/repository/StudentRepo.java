package com.ashiq.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashiq.contactbook.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
