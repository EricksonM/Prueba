package com.example.demo.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Document(collection = "PlaylistFlux")
public class Playlist {

	@Id
	private String id;
	private String name;
	private int time;
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@DateTimeFormat(iso = ISO.DATE)
	private Date releaseDate = new Date();
	
}
