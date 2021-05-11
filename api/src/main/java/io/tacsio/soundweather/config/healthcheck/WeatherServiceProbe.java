package io.tacsio.soundweather.config.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import io.tacsio.soundweather.service.weather.WeatherResponse;
import io.tacsio.soundweather.service.weather.WeatherService;

@Readiness
public class WeatherServiceProbe implements HealthCheck {

	private WeatherService weatherService;

	public WeatherServiceProbe(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@Override
	public HealthCheckResponse call() {

		WeatherResponse temperature = weatherService.getTemperature("Recife");

		if (temperature != null) {
			return HealthCheckResponse.up("Weather Service ready to response.");
		} else {
			return HealthCheckResponse.up("Weather Service not ready to response.");
		}
	}

}
