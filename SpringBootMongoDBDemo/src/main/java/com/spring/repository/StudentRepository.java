package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.document.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	List<Student> findByFirstName(String firstName);
	
	//probar método con fecha
	List<Student> findByBirthdayDate(LocalDate birthdayDate);
	
	List<Student> findByBirthdayDateBetween(LocalDate birthdayDate1,LocalDate birthdayDate2);
}
