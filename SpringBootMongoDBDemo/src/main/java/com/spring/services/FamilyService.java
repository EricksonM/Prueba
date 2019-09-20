package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.document.Family;
import com.spring.repository.FamilyRepository;

@Service
public class FamilyService {

	@Autowired
	private FamilyRepository _familyRepository;
	
	public Family createFamily(Family family) {
		return _familyRepository.save(family);
	}
	
	public List<Family> getFamily(){
		return _familyRepository.findAll();
	}
	
	public Family updateFamily(Family family) {
		return _familyRepository.save(family);
	}
	
	public void deleteFamily(String id) {
		_familyRepository.deleteById(id);
	}
	
	public void deleteAllFamily() {
		_familyRepository.deleteAll();
	}
	
	public Optional<Family> getFamilyById(String id) {
		return _familyRepository.findById(id);
	}
	
	public List<Family> getFamilyByIdStudent(String idStudent){
		return _familyRepository.findByIdStudent(idStudent);
	}
}








