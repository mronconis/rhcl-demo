package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {
    @Test
    void testV1Endpoint() {
        given()
          .when().get("/v1/user/1")
          .then()
             .statusCode(200)
             .body(is("{surname=Rossi, name=Mario}"));
    }
}