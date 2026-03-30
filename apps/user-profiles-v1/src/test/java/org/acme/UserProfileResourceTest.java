package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserProfileResourceTest {

    @Test
    void testGetUserProfileEndpoint() {
        given()
          .header("x-user-id", "alice")
          .when().get("/v1/user/profile")
          .then()
             .statusCode(200)
             .body("role", is("admin"))
             .body("department", is("IT"));
    }

    @Test
    void testGetUserProfileHeaderEndpoint() {
        given()
          .when().get("/v1/user/profile")
          .then()
             .statusCode(400);
    }
}