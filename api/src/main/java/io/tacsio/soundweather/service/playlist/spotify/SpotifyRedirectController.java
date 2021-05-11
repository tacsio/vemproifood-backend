package io.tacsio.soundweather.service.playlist.spotify;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/spotify-redirect")
public class SpotifyRedirectController {

	@GET
	public Response retrieveCode(UriInfo request) {

		System.out.println(request.getQueryParameters());

		return Response.ok().build();
	}
}
