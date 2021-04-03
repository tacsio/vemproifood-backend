package io.tacsio.soundweather.service.genre;

import java.util.function.Predicate;

public enum Genre {
	PARTY((temperature) -> temperature > 30), 
	POP((temperature) -> temperature >= 15 && temperature <= 30), 
	ROCK((temperature) -> temperature >= 10 && temperature <= 14), 
	CLASSICAL((temperature) -> temperature < 10);

	private Predicate<Float> temperatureFilter;

	private Genre(Predicate<Float> temperatureFilter) {
		this.temperatureFilter = temperatureFilter;
	}

	public boolean filter(Float temperature) {
		return this.temperatureFilter.test(temperature);
	}

}
