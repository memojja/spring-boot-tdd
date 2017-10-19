package com.springboottdd.springboottdd.resources;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class PersonResourceTest {

    @Test
    public void name() throws Exception {

        given()
                .pathParam("tc","3313666945")
                .pathParam("name","mehmet")
        .get("/persons/{name}/{tc}")
        .then()
                .log().body().and()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "tc",equalTo("3313666945"),
                        "name",equalTo("mehmet")
                );
    }
}
