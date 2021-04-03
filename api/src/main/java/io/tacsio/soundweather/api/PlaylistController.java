package io.tacsio.soundweather.api;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.tacsio.soundweather.service.genre.Genre;
import io.tacsio.soundweather.service.genre.MusicGenreSelector;
import io.tacsio.soundweather.service.playlist.PlaylistService;
import io.tacsio.soundweather.service.weather.WeatherResponse;
import io.tacsio.soundweather.service.weather.WeatherService;

@Path("playlists")
public class PlaylistController {

	private WeatherService weatherService;
	private MusicGenreSelector genreSelector;
	private PlaylistService playlistService;

	public PlaylistController(WeatherService weatherService, MusicGenreSelector selector,
			PlaylistService playlistService) {
		this.weatherService = weatherService;
		this.genreSelector = selector;
		this.playlistService = playlistService;
	}

	@GET
	public Response playlist(@QueryParam("city") String city, @QueryParam("lat") BigDecimal latitude,
			@QueryParam("lon") BigDecimal longitude) {

		WeatherResponse weather;

		if (city != null && !city.isBlank()) {
			weather = weatherService.getTemperature(city);
		} else {
			weather = weatherService.getTemperature(latitude, longitude);
		}

		Genre genre = genreSelector.selectByTemperature(weather.getTemperature());
		List<String> playlist = playlistService.selectByGenre(genre);

		return Response.ok(playlist).build();
	}

}
