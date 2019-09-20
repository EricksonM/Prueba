package com.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.document.Student;
import com.spring.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService _studentService;
		
	@PostMapping("/")
	public Student createStudent(@RequestBody Student student) {
		return _studentService.createStudent(student);
	}
	
	@GetMapping("/")
	public List<Student> getAllStudents(){
		return _studentService.getAllStudents();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") String id) {
		return _studentService.getStudentById(id);
	}
	
	@GetMapping("/name/{firstName}")
		public List<Student> getStudentByFirstName(@PathVariable("firstName") String firstName){
			return _studentService.getStudentByFirstName(firstName);
		}
	
	@PutMapping("/")
	public Student updateStudent(@RequestBody Student student) {
		return _studentService.updateStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id") String id) {
		_studentService.deleteStudent(id);
		return "Se eliminó el registro de " + id;
	}
	
	//Prueba método con fecha
	@GetMapping("/date/{date}")
	public List<Student> getStudentsByDate(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE) LocalDate birthdayDate){
		return _studentService.getStudentByBirthday(birthdayDate);
	}
	
	@GetMapping("/dates/{date1}/{date2}")
	public List<Student> getStudentsByBetweenDates(@PathVariable("date1") @DateTimeFormat(iso = ISO.DATE) LocalDate date1,
												   @PathVariable("date2") @DateTimeFormat(iso = ISO.DATE) LocalDate date2){
		return _studentService.getStudentByBetweenDates(date1, date2);
	}
	
	@DeleteMapping("/")
	public String deleteAllStudents() {
		_studentService.deleteAllStudents();
		return "Se eliminaron todos los resgistros";
		
	}
}





