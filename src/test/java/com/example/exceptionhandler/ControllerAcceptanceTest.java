package com.example.exceptionhandler;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ControllerAcceptanceTest extends AcceptanceTest {

    @Test
    void exceptionHandlerInController() {
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .when().get("/controller")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    void controllerAdvice() {
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .when().get("/controllerAdvice")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    void controllerAdviceWithResponseStatus() {
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .when().get("/responseStatusInAdvice")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test
    void responseStatusInException() {
        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .when().get("/responseStatus")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(500);
    }
}
