package com.spring.controller;

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
import com.spring.services.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

	@MockBean
	private StudentService service;
	
	@Autowired
	private StudentController controller;
	
	@Test
	public void testCreateStudent() {
		Student student = mock(Student.class);
		when(service.createStudent(student)).thenReturn(student);
		assertEquals(student, controller.createStudent(student));
	}

	@Test
	public void testGetAllStudents() {
		when(service.getAllStudents())
				.thenReturn(Stream.of(mock(Student.class), mock(Student.class))
				.collect(Collectors.toList()));
	}

	//******** Verificar **********
	@Test
	public void testGetStudentById() {
		String id = mock(Student.class).getId();
		Student student = mock(Student.class);
		when(service.getStudentById(id)).thenReturn(Optional.of(student));
		assertEquals(student, controller.getStudentById(id).get());
	}

	@Test
	public void testGetStudentByFirstName() {
		String firstName = mock(Student.class).getFirstName();
		when(service.getStudentByFirstName(firstName))
					.thenReturn(Stream.of(mock(Student.class), mock(Student.class))
					.collect(Collectors.toList()));
		assertEquals(2, controller.getStudentByFirstName(firstName).size());
	}

	@Test
	public void testUpdateStudent() {
		Student student = mock(Student.class);
		when(service.updateStudent(student)).thenReturn(student);
		assertEquals(student, controller.updateStudent(student));
	}

	@Test
	public void testDeleteStudent() {
		String id = mock(Student.class).getId();
		controller.deleteStudent(id);
		verify(service, times(1)).deleteStudent(id);
	}

	@Test
	public void testGetStudentsByDate() {
		LocalDate birthdayDate = LocalDate.now();
		when(service.getStudentByBirthday(birthdayDate))
					.thenReturn(Stream.of(mock(Student.class), mock(Student.class))
					.collect(Collectors.toList()));
		assertEquals(2, controller.getStudentsByDate(birthdayDate).size());
	}

	@Test
	public void testGetStudentsByBetweenDates() {
		LocalDate birthdayDate1 = LocalDate.MIN;
		LocalDate birthdayDate2 = LocalDate.MAX;
		when(service.getStudentByBetweenDates(birthdayDate1, birthdayDate2))
					.thenReturn(Stream.of(mock(Student.class), mock(Student.class))
					.collect(Collectors.toList()));
		assertEquals(2, controller.getStudentsByBetweenDates(birthdayDate1, birthdayDate2).size());
	}

	@Test
	public void testDeleteAllStudents() {
		controller.deleteAllStudents();
		verify(service, times(1)).deleteAllStudents();
	}

}
