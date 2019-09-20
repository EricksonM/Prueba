package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlaylistRouter {

	@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler handler){
		
		return RouterFunctions
				.route(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::createPlaylist)
				.andRoute(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::getAllPlaylist)
				.andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getPlaylistById)
				.andRoute(PUT("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::updatePlaylist)
				.andRoute(DELETE("/playlist/{id}"), handler::deletePlaylist)
				.andRoute(GET("/playlist/date/{date}").and(accept(MediaType.APPLICATION_JSON)), handler::getPlaylistByDate)
				.andRoute(GET(("/playlist/date/{date1}/{date2}")).and(accept(MediaType.APPLICATION_JSON)), handler::getPlaylistByBetweenDate);
	}
}
