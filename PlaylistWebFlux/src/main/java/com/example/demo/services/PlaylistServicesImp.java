package com.example.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.Playlist;
import com.example.demo.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServicesImp implements PlaylistService{

	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Override
	public Flux<Playlist> findAll() {
		return playlistRepository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return playlistRepository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return playlistRepository.save(playlist);
	}

	@Override
	public Flux<Playlist> findByName(String name) {
		
		return playlistRepository.findByName(name);
	}

	@Override
	public Flux<Playlist> findByReleaseDate(Date date) {
		return playlistRepository.findByReleaseDate(date);
	}

	@Override
	public Flux<Playlist> findByReleaseDateBetween(Date date1, Date date2) {
		return playlistRepository.findByReleaseDateBetween(date1, date2);
	}

	@Override
	public Mono<Void> deletePlaylistById(String id) {
		return playlistRepository.deleteById(id);
	}

	@Override
	public Mono<Void> deleteAllPlaylist() {
		return playlistRepository.deleteAll();
	}


}
