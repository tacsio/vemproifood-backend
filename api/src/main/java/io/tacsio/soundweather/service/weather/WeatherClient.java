package io.tacsio.soundweather.service.weather;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "weather-service")
public interface WeatherClient {

	@GET
	WeatherResponse getTemperature(@QueryParam("q") String city, @QueryParam("units") String units,
			@QueryParam("appid") String apiKey);

	@GET
	WeatherResponse getTemperature(@QueryParam("lat") BigDecimal latitude, @QueryParam("lon") BigDecimal longitude,
			@QueryParam("units") String units, @QueryParam("appid") String apiKey);

}