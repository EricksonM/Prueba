package com.spring.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.document.Student;
import com.spring.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@MockBean
	private StudentRepository repository;
	
	@Autowired
	private StudentService service;
	
	@Test
	public void testCreateStudent() {
		Student student = mock(Student.class);
		when(repository.insert(student)).thenReturn(student);
		assertEquals(student,service.createStudent(student));
	}
	
	@Test
	public void testGetAllStudents() {
		when(repository.findAll()).thenReturn(Stream.of(mock(Student.class), mock(Student.class))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllStudents().size());
	}

	
	//******** Verificar **********
	@Test
	public void testGetStudentById() {
		String id = "10";
		Student st = mock(Student.class);
		when(repository.findById(id)).thenReturn(Optional.of(st));
		
		assertEquals(st, service.getStudentById(id).get());
	}

	@Test
	public void testGetStudentByFirstName() {
		String firstName = "Liam";
		when(repository.findByFirstName(firstName))
				.thenReturn(Stream.of(mock(Student.class))
				.collect(Collectors.toList()));
		assertEquals(1, service.getStudentByFirstName(firstName).size());
	}

	@Test
	public void testGetStudentByBirthday() {
		LocalDate birthdayDate = LocalDate.now();
		when(repository.findByBirthdayDate(birthdayDate))
					.thenReturn(Stream.of(mock(Student.class))
					.collect(Collectors.toList()));
		assertEquals(1, service.getStudentByBirthday(birthdayDate).size());
	}
	
	@Test
	public void testGetStudentByBetweenDates() {
		LocalDate birthdayDate1 = LocalDate.MIN;
		LocalDate birthdayDate2 = LocalDate.MAX;
		when(repository.findByBirthdayDateBetween(birthdayDate1, birthdayDate2))
					.thenReturn(Stream.of(mock(Student.class), mock(Student.class))
					.collect(Collectors.toList()));
		assertEquals(2, service.getStudentByBetweenDates(birthdayDate1, birthdayDate2).size());
	}

	@Test
	public void testUpdateStudent() {
		Student student = mock(Student.class);
		when(repository.save(student)).thenReturn(student);
		assertEquals(student, service.updateStudent(student));
		
	}

	@Test
	public void testDeleteStudent() {
		String id = mock(Student.class).getId();
		service.deleteStudent(id);
		verify(repository, times(1)).deleteById(id);
	}

	@Test
	public void testDeleteAllStudents() {
		service.deleteAllStudents();
		verify(repository, times(1)).deleteAll();
	}


	
}
