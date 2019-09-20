package com.example.demo.services;

import java.util.Date;

import com.example.demo.document.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

	Flux<Playlist> findAll();
	Mono<Playlist> findById(String id);
	Mono<Playlist> save(Playlist playlist);
	Flux<Playlist> findByName(String name);
	Flux<Playlist> findByReleaseDate(Date date);
	Flux<Playlist> findByReleaseDateBetween(Date date1, Date date2);
	Mono<Void> deletePlaylistById(String id);
	Mono<Void> deleteAllPlaylist();
}
