package com.example.demo.repository;

import java.time.LocalDate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.Playlist;

import reactor.core.publisher.Flux;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

	Flux<Playlist> findByReleaseDate(LocalDate date);
	
	Flux<Playlist> findByReleaseDateBetween(LocalDate date1, LocalDate date2);
}
