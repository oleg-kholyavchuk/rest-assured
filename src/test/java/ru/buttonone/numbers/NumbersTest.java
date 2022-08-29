package ru.buttonone.numbers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    public static final String NUMBERS_URL = "http://numbersapi.com";
    public static final String NUMBERS_URL_MATH = "http://numbersapi.com/#5/math";
    public static final String NUMBERS_URL_DATE = "http://numbersapi.com/#8/29/date";
    public static final String HTTP_200_OK = "HTTP/1.1 200 OK";

    @DisplayName("Checking the correctness of the Content-Type field display")
    @Test
    public void shouldHaveCorrectGet2() {

//        Response response = RestAssured.given().get("http://numbersapi.com/2");
//
//        System.out.println("response.statusCode() = " + response.statusCode());
//
//        Assertions.assertEquals(200, response.statusCode());

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .get("/2")
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the Mathematics section")
    @Test
    public void shouldHaveCorrectGetMath() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .get("/5/math")
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the Mathematics section")
    @Test
    public void shouldHaveCorrectGetMth() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .get("/5/math")
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the dates section")
    @Test
    public void shouldHaveCorrectGetDate() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .get("/8/29/date")
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking for the correct options")
    @Test
    public void shouldHaveCorrectOptions() {

        RestAssured
                .given()
                .options(NUMBERS_URL)
                .then()
                .log().all();
    }

    @DisplayName("Checking for the correct head")
    @Test
    public void shouldHaveCorrectHead() {

        RestAssured
                .given()
                .head(NUMBERS_URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking for the correct head date")
    @Test
    public void shouldHaveCorrectHeadDate() {

        RestAssured
                .given()
                .head(NUMBERS_URL_DATE)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking for the correct head math")
    @Test
    public void shouldHaveCorrectHeadMath() {

        RestAssured
                .given()
                .head(NUMBERS_URL_MATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking the NUMBERS_URL is correct")
    @Test
    public void shouldHaveCorrectGetNumbersUrl() {

        RestAssured
                .get(NUMBERS_URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking have correct head status line")
    @Test
    public void shouldHaveCorrectHeadStatusLine() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .head()
                .then()
                .statusLine(HTTP_200_OK)
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking if the url can be deleted")
    @Test
    public void checkingUrlCannotDeleted() {

        RestAssured
                .given()
                .delete(NUMBERS_URL)
                .then()
                .log().all()
                .statusCode(404);
    }
}

