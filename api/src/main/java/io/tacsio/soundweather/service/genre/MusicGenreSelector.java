package io.tacsio.soundweather.service.genre;

import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MusicGenreSelector {

	public Genre selectByTemperature(Float temperature) {

		 Genre genre = Stream.of(Genre.values())
			.filter(it -> it.filter(temperature))
			.findFirst()
			.orElseThrow(() ->  new IllegalArgumentException("No genre for this temperature"));

		return genre;

	}
}
