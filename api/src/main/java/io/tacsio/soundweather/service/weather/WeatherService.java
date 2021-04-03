package io.tacsio.soundweather.service.weather;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class WeatherService {

	@Inject
	@RestClient
	private WeatherClient weatherClient;

	@ConfigProperty(name = "weather-service.api-key")
	private String apiKey;

	@ConfigProperty(name = "weather-service.units")
	private String units;

	public WeatherResponse getTemperature(String city) {
		return weatherClient.getTemperature(city, units, apiKey);
	}

	public WeatherResponse getTemperature(BigDecimal latitude, BigDecimal longitude) {
		return weatherClient.getTemperature(latitude, longitude, units, apiKey);
	}
}
