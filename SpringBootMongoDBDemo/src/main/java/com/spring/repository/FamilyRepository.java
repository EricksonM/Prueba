package com.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.document.Family;

@Repository
public interface FamilyRepository extends MongoRepository<Family, String>{

	List<Family> findByIdStudent(String idStudent);
}
