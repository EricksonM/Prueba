package com.example.demo.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.Playlist;
import com.example.demo.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService {

	@Autowired
	private PlaylistRepository _playlistRepository;
	
	public Mono<Playlist> createPlaylist(Playlist playlist){
		return _playlistRepository.save(playlist);
	}
	
	public Flux<Playlist> getAllPlaylist(){
		return _playlistRepository.findAll();
	}
	
	public Mono<Playlist> getPlaylistById(String id){
		return _playlistRepository.findById(id);
	}
	
	public Mono<Playlist> updatePlaylist(Playlist playlist){
		return _playlistRepository.save(playlist);
	}
	
	public Mono<Void> deletePlaylist(String id){
		return _playlistRepository.deleteById(id);
	}
	
	public Flux<Playlist> getPlaylistByDate(LocalDate date){
		
		return _playlistRepository.findByReleaseDate(date);
	}
	
	public Flux<Playlist> getPlaylistByBetweenDate(LocalDate date1, LocalDate date2){
		return _playlistRepository.findByReleaseDateBetween(date1, date2);
	}
	
}
