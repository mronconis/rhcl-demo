package org.acme;

import java.util.HashMap;
import java.util.Map;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v2/user")
public class UserResourceV2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id:[0-9]+}")
    public Map<String,String>  user(@PathParam("id") String id) {
        Log.info("Get User by ID: " + id);
        Map<String,String> user = new HashMap<>();
        user.put("name", "Mario");
        user.put("surname", "Rossi");
        user.put("username", "mrossi");
        return user;
    }
}
