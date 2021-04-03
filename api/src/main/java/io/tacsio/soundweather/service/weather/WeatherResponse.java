package io.tacsio.soundweather.service.weather;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

	private Float temperature;

	public Float getTemperature() {
		return temperature;
	}

	@JsonProperty("main")
	public void setTemperature(Map<String, String> main) {
		String tempString = main.get("temp");
		this.temperature = Float.parseFloat(tempString);
	}
}