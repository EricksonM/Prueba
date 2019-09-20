package com.example.demo.controller;

import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Playlist;
import com.example.demo.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping("/")
	public Flux<Playlist> getPlaylist(){
		return playlistService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Playlist> getPlaylistId(@PathVariable String id){
		return playlistService.findById(id);
	}
	
	@PostMapping("/")
	public Mono<Playlist> save(@RequestBody Playlist playlist){
		return playlistService.save(playlist);
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents(){
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<Playlist> events = playlistService.findAll();
		System.out.println("Paso de eventos");
		
		return Flux.zip(interval, events);
	}
	
	@GetMapping("/name/{name}")
	public Flux<Playlist> buscarPorNombre(@PathVariable("name") String nombre){
		return playlistService.findByName(nombre);
	}
	
	@GetMapping("/date/{date}")
	public Flux<Playlist> buscarPorFecha(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE) Date date){
		return playlistService.findByReleaseDate(date);
	}
	
	@GetMapping("/date1/{date1}/{date2}")
	public Flux<Playlist> buscarEntreFechas(@PathVariable("date1") @DateTimeFormat(iso = ISO.DATE) Date date1,
											@PathVariable("date2") @DateTimeFormat(iso = ISO.DATE) Date date2){
		return playlistService.findByReleaseDateBetween(date1, date2);
	}
	
	
	@DeleteMapping("/{id}")
	public Mono<Void> deletePlaylistById(@PathVariable("id") String id){
		return playlistService.deletePlaylistById(id);
	}
	
	@DeleteMapping
	public Mono<Void> deleteAllPlaylist(){
		return playlistService.deleteAllPlaylist();
	}
	
	
	
}








