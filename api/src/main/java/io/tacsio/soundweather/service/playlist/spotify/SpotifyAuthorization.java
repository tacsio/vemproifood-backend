package io.tacsio.soundweather.service.playlist.spotify;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class SpotifyAuthorization {

	@ConfigProperty(name = "spotify-service.client-id")
	String clientId;
	
	@ConfigProperty(name = "spotify-service.redirect-uri")
	String redirectUri;

	@ConfigProperty(name = "spotify-service.code-challenge")
	String codeChallenge;
	
	public URI authorizationURI() {
		SpotifyApi api = new SpotifyApi.Builder()
			.setClientId(clientId)
			.setRedirectUri(SpotifyHttpManager.makeUri(redirectUri))
			.build();


			return api.authorizationCodePKCEUri(codeChallenge)
				.build()
				.execute();
	}


}
