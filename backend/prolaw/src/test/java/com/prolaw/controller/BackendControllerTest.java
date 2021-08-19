package com.prolaw.controller;
/*

import com.prolaw.ProlawApplication;
import com.prolaw.domain.User;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest( classes = ProlawApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
*/
public class BackendControllerTest {
/*
    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI ="http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void saysHello() {
        when()
             .get("/api/hello")
        .then()
              .statusCode(HttpStatus.SC_OK)
              .assertThat()
                  .body(is(equalTo(BackendController.HELLO_TEXT)));
    }

    @Test
    public void addUserAndRetriveItBack() {
        //User gustavoMojica = new User("Gustavo","Mojica","3228056671","gmojica@unal.edu.co","1234");
        //User gustavoMojica = new User("1192894877","Gustavo","Mojica","3228056671","gmojica@unal.edu.co","1234");
        String userId = 
            given()
                .pathParam("idUser", "1010012720")
                .pathParam("nameUser", "Camilo")
                .pathParam("lastNameUser", "Cardona")
                .pathParam("celUser", "3208")
                .pathParam("emailUser", "ancardonac@unal.edu.co")
                .pathParam("passUser", "1234")
            .when()
                .post("api/user/{idUser}/{nameUser}/{lastNameUser}/{celUser}/{emailUser}/{passUser}")
            .then()
                .statusCode(is(HttpStatus.SC_CREATED))
                .extract()
                    .body().as(String.class);
            
        User responseUser =
            given()
                .pathParam("idUser", userId)
            .when()
                .get("api/user/{idUser}")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                    .extract().as(User.class);
        
        assertThat(responseUser.getLastNameUser(), is("Cardona"));
    }

    @Test
	public void user_api_should_give_http_404_not_found_when_user_not_present_in_db() {
		Long someId = 200L;
		given()
			.pathParam("idUser", someId)
			.get("/api/user/{idUser}")
		.then()
			.statusCode(HttpStatus.SC_NOT_FOUND);
	}

	@Test
	public void secured_api_should_react_with_unauthorized_per_default() {

		given()
		.when()
			.get("/api/secured")
		.then()
			.statusCode(HttpStatus.SC_UNAUTHORIZED);
	}

	@Test
	public void secured_api_should_give_http_200_when_authorized() {

		given()
			.auth().basic("prolaw", "prolaw")
		.when()
			.get("/api/secured")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body(is(equalTo(BackendController.SECURED_TEXT)));
	}

    @Test
    public void loginUserTest() {     
        boolean responseLogin =
            given()
                .pathParam("emailUser", "gmojica@unal.edu.co")
                .pathParam("passUser", "1234")
            .when()
                .get("api/user/{emailUser}/{passUser}")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                    .extract().as(boolean.class);
        
        assertTrue(responseLogin);
    }
*/    
}
