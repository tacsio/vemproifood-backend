package io.tacsio.soundweather.config.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class SpotifyServiceProbe implements HealthCheck {

	@Override
	public HealthCheckResponse call() {

		// TODO: readness logic
		return HealthCheckResponse.up("Spotify service is ready to response.");
	}

}
