package com.spring.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.document.Student;
import com.spring.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository _studentRepository;
	
	public Student createStudent(Student student) {
		return _studentRepository.insert(student);
	}
	
	public List<Student> getAllStudents(){
		List<Student> lista = _studentRepository.findAll();
		System.out.println("lista en la BD " + lista);
		return _studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(String id) {
		return _studentRepository.findById(id);
	}
	
	public List<Student> getStudentByFirstName(String firstName){
		return _studentRepository.findByFirstName(firstName);
	}
	
	//Prueba método con fecha
	public List<Student> getStudentByBirthday(LocalDate birthdayDate){
		return _studentRepository.findByBirthdayDate(birthdayDate);
	}
	
	public List<Student> getStudentByBetweenDates(LocalDate date1, LocalDate date2){
		return _studentRepository.findByBirthdayDateBetween(date1, date2);
	}
	
	public Student updateStudent(Student student) {
		return _studentRepository.save(student);
	}
	
	public void deleteStudent(String id) {
		_studentRepository.deleteById(id);
	}
	
	public void deleteAllStudents() {
		_studentRepository.deleteAll();
	}
	
	
}
