package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import com.example.demo.document.Playlist;
import com.example.demo.services.PlaylistService;

import reactor.core.publisher.Mono;

@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistService _playlistService;

	public Mono<ServerResponse> createPlaylist(ServerRequest request) {
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);

		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(_playlistService::createPlaylist), Playlist.class));
	}

	public Mono<ServerResponse> getAllPlaylist(ServerRequest request) {
		return ok().contentType(MediaType.APPLICATION_JSON).body(_playlistService.getAllPlaylist(), Playlist.class);
	}

	public Mono<ServerResponse> getPlaylistById(ServerRequest request) {
		String id = request.pathVariable("id");

		return ok().contentType(MediaType.APPLICATION_JSON).body(_playlistService.getPlaylistById(id), Playlist.class);
	}

	public Mono<ServerResponse> updatePlaylist(ServerRequest request) {
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);

		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(_playlistService::updatePlaylist), Playlist.class));
	}

	public Mono<ServerResponse> deletePlaylist(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().build(_playlistService.deletePlaylist(id))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getPlaylistByDate(ServerRequest request) {
		LocalDate date;
		date = LocalDate.parse(request.pathVariable("date"), DateTimeFormatter.ISO_DATE);
		return ok().contentType(MediaType.APPLICATION_JSON).body(_playlistService.getPlaylistByDate(date),
				Playlist.class);
	}
	
	public Mono<ServerResponse> getPlaylistByBetweenDate(ServerRequest request){
		LocalDate date1 = LocalDate.parse(request.pathVariable("date1"), DateTimeFormatter.ISO_DATE);
		LocalDate date2 = LocalDate.parse(request.pathVariable("date2"), DateTimeFormatter.ISO_DATE);
		
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(_playlistService.getPlaylistByBetweenDate(date1, date2), Playlist.class);
	}
}
