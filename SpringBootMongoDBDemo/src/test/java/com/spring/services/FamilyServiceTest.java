package com.spring.services;

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
import com.spring.repository.FamilyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyServiceTest {

	@MockBean
	private FamilyRepository repository;
	
	@Autowired
	private FamilyService service;
	
	@Test
	public void testCreateFamily() {
		Family family = mock(Family.class);
		when(repository.save(family)).thenReturn(family);
		assertEquals(family, service.createFamily(family));
	}

	@Test
	public void testGetFamily() {
		when(repository.findAll()).thenReturn(Stream.of(mock(Family.class), mock(Family.class))
							.collect(Collectors.toList()));
		assertEquals(2, service.getFamily().size());
	}

	@Test
	public void testUpdateFamily() {
		Family family = mock(Family.class);
		when(repository.save(family)).thenReturn(family);
		assertEquals(family, service.createFamily(family));
	}

	@Test
	public void testDeleteFamily() {
		String id = mock(Family.class).getId();
		service.deleteFamily(id);
		verify(repository, times(1)).deleteById(id);
	}

	@Test
	public void testDeleteAllFamily() {
		service.deleteAllFamily();
		verify(repository, times(1)).deleteAll();
	}

	//******** Verificar **********
	@Test
	public void testGetFamilyById() {
		String id = mock(Family.class).getId();
		Family family = mock(Family.class);
		when(repository.findById(id)).thenReturn(Optional.of(family));
		assertEquals(family, service.getFamilyById(id).get());
	}

	@Test
	public void testGetFamilyByIdStudent() {
		String idStudent = mock(Family.class).getIdStudent();
		when(repository.findByIdStudent(idStudent))
						.thenReturn(Stream.of(mock(Family.class), mock(Family.class), mock(Family.class))
						.collect(Collectors.toList()));
		assertEquals(3, service.getFamilyByIdStudent(idStudent).size());
	}

}
