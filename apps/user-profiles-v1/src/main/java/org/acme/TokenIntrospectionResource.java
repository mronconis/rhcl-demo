package org.acme;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;

@Path("/v1/token/introspect")
public class TokenIntrospectionResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public IntrospectionResponse introspectToken(@FormParam("token") String token) {
        Log.info("Validate token: "+token);
        boolean isTokenValid = validateTokenJwt(token);

        if (isTokenValid) {
            String userId = extractUserId(token);
            String role = extractRole(token);
            Log.info("Valid token!");
            return new IntrospectionResponse(true, userId, role);
        } else {
            Log.warn("Invalid token!");
            return new IntrospectionResponse(false, null, null);
        }
    }

    private boolean validateTokenJwt(String token) { 
        return token != null && !token.isEmpty(); 
    }

    private String extractUserId(String token) { 
        return "usr_123"; 
    }

    private String extractRole(String token) { 
        return "admin"; 
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record IntrospectionResponse(
        boolean active,
        String sub,
        String role
    ) {}
}