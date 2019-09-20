package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.Playlist;

import reactor.core.publisher.Flux;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

	Flux<Playlist> findByName(String name);
	
	Flux<Playlist> findByReleaseDate(Date date);
	
	Flux<Playlist> findByReleaseDateBetween(Date date1, Date date2);
}
