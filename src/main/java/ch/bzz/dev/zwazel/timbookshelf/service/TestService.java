package ch.bzz.dev.zwazel.timbookshelf.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("test")
public class TestService {
    @GET
    @Produces("text/plain")
    @Path("test")
    public Response test() {
        return Response
                .status(200)
                .entity("test erfolgreich")
                .build();
    }
}
