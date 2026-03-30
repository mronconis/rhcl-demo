package org.acme;

import java.util.HashMap;
import java.util.Map;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.BadRequestException;

@Path("/v1/user/profile")
public class UserProfileResourceV2 {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfile userProfile(@Context HttpHeaders headers) {
        String userId = headers.getHeaderString("x-user-id");
        Log.info("Get User Profile by UserId: " + userId);
        
        if (userId == null || userId.trim().isEmpty()) {
            Log.warn("Bad Request: header x-user-id not found.");
            throw new BadRequestException("Header x-user-id is required!");
        }

        return new UserProfile("admin","IT", new UserRateLimit(10, "minute"));
    }

    public record UserProfile(
        String role,
        String department,
        UserRateLimit rateLimit
    ) {}

    public record UserRateLimit(
        int limit,
        String unit
    ) {}
    
}
