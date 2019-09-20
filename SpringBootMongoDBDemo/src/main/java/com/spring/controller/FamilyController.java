package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.document.Family;
import com.spring.services.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {

	@Autowired
	private FamilyService _familyService;
	
	@PostMapping("/")
	public Family createFamily(@RequestBody Family family) {
		return _familyService.createFamily(family);
	}
	
	@GetMapping("/")
	public List<Family> getFamily(){
		return _familyService.getFamily();
	}
	
	@PutMapping("/")
	public Family updateFamily(@RequestBody Family family) {
		return _familyService.updateFamily(family);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFamily(@PathVariable("id") String id) {
		_familyService.deleteFamily(id);
		return "Se eliminó el registro del ID " + id;
	}
	
	@DeleteMapping("/")
	public String deleteAllFamily() {
		_familyService.deleteAllFamily();
		return "Se eliminaron todos los registros";
	}
	
	@GetMapping("/{id}")
	public Optional<Family> getFamilyById(@PathVariable("id") String id) {
		return _familyService.getFamilyById(id);
	}
	
	@GetMapping("/idStudent/{id}")
	public List<Family> getFamilyByIdStudent(@PathVariable("id") String idStudent){
		return _familyService.getFamilyByIdStudent(idStudent);
	}
}








