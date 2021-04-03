package io.tacsio.soundweather.service.playlist;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.tacsio.soundweather.service.genre.Genre;

@ApplicationScoped
public class PlaylistService {

	public List<String> selectByGenre(Genre genre) {

		return List.of("track 1", "track 2");
	}
}
