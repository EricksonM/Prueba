package com.spring.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.document.Family;
import com.spring.services.FamilyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyControllerTest {

	@MockBean
	private FamilyService service;
	
	@Autowired
	private FamilyController controller;
	
	@Test
	public void testCreateFamily() {
		Family family = mock(Family.class);
		when(service.createFamily(family)).thenReturn(family);
		assertEquals(family, controller.createFamily(family));
	}

	@Test
	public void testGetFamily() {
		when(service.getFamily()).thenReturn(Stream.of(mock(Family.class), mock(Family.class))
					.collect(Collectors.toList()));
		assertEquals(2, controller.getFamily().size());
	}

	@Test
	public void testUpdateFamily() {
		Family family = mock(Family.class);
		when(service.updateFamily(family)).thenReturn(family);
		assertEquals(family, controller.updateFamily(family));
	}

	@Test
	public void testDeleteFamily() {
		String id = mock(Family.class).getId();
		controller.deleteFamily(id);
		verify(service, times(1)).deleteFamily(id);
	}

	@Test
	public void testDeleteAllFamily() {
		controller.deleteAllFamily();
		verify(service, times(1)).deleteAllFamily();
	}

	@Test
	public void testGetFamilyById() {
		String id = mock(Family.class).getId();
		Family family = mock(Family.class);
		when(service.getFamilyById(id)).thenReturn(Optional.of(family));
		assertEquals(family, controller.getFamilyById(id).get());
	}

	@Test
	public void testGetFamilyByIdStudent() {
		String idStudent = mock(Family.class).getIdStudent();
		when(service.getFamilyByIdStudent(idStudent))
						.thenReturn(Stream.of(mock(Family.class), mock(Family.class), mock(Family.class))
						.collect(Collectors.toList()));
		assertEquals(3, controller.getFamilyByIdStudent(idStudent).size());
	}

}
