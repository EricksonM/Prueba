package com.spring.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Document(collection = "Family")
public class Family {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date birthdayDate;
	private String docType;
	private String docNumber;
	private String idStudent;
	private String familyRelationship;
}
