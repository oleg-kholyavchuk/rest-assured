package ru.buttonone.numbers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ru.buttonone.specification.NumbersSpecifications.*;

public class NumbersTest {

    public static final String NUMBERS_URL = "http://numbersapi.com";
    public static final String NUMBERS_URL_MATH = "http://numbersapi.com/#5/math";
    public static final String NUMBERS_URL_DATE = "http://numbersapi.com/#8/29/date";
    public static final String HTTP_200_OK = "HTTP/1.1 200 OK";
    public static final String CONTENT_TYPE = "text/html; charset=utf-8";

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
                .pathParam("id", 3)
                .when()
                .get("/{id}")
                .then()
                .contentType(ContentType.TEXT)
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the Mathematics section")
    @Test
    public void shouldHaveCorrectGetMath() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .when()
                .get("/5/math")
                .then()
                .contentType(ContentType.TEXT)
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the Mathematics section")
    @Test
    public void shouldHaveCorrectGetMath5() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .when()
                .get("/5/math")
                .then()
                .contentType(ContentType.TEXT)
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking whether the Content Type field is displayed correctly in the dates section")
    @Test
    public void shouldHaveCorrectGetDate() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .when()
                .get("/8/29/date")
                .then()
                .contentType(ContentType.TEXT)
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking for the correct options")
    @Test
    public void shouldHaveCorrectOptions() {

        RestAssured
                .given()
                .and()
                .when()
                .options(NUMBERS_URL)
                .then()
                .log().all();
    }

    @DisplayName("Checking for the correct head")
    @Test
    public void shouldHaveCorrectHead() {

        RestAssured
                .given()
                .and()
                .when()
                .head(NUMBERS_URL)
                .then()
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking for the correct head date")
    @Test
    public void shouldHaveCorrectHeadDate() {

        RestAssured
                .given()
                .and()
                .when()
                .head(NUMBERS_URL_DATE)
                .then()
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking for the correct head math")
    @Test
    public void shouldHaveCorrectHeadMath() {

        RestAssured
                .given()
                .and()
                .when()
                .head(NUMBERS_URL_MATH)
                .then()
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking the NUMBERS_URL is correct")
    @Test
    public void shouldHaveCorrectGetNumbersUrl() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .when()
                .get(NUMBERS_URL)
                .then()
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking have correct head status line")
    @Test
    public void shouldHaveCorrectHeadStatusLine() {

        RestAssured
                .given()
                .baseUri(NUMBERS_URL)
                .when()
                .head()
                .then()
                .statusLine(HTTP_200_OK)
//                .log().all()
//                .statusCode(200);
                .spec(defaultResponseSpecification(200));
    }

    @DisplayName("Checking if the url can be deleted")
    @Test
    public void checkingUrlCannotDeleted() {

        RestAssured
                .given()
                .and()
                .when()
                .delete(NUMBERS_URL)
                .then()
//                .log().all()
//                .statusCode(404);
                .spec(defaultResponseSpecification(404));
    }

    @DisplayName("Checking the correctness of the request math")
    @Test
    public void shouldHaveCorrectRequestMath() {

        RestAssured
                .given()
                .spec(defaultRequestSpecificationDateAndMath("Accept-Language", "ru", "/t/math"))
                //.header("Accept-Language", "ru")
                //.baseUri(NUMBERS_URL)
                .when()
                .get(idData)
                .then()
//                .log().all()
//                .statusCode(404);
                .spec(defaultResponseSpecification(404));
    }

    @DisplayName("Checking the correctness of the request date")
    @Test
    public void shouldHaveCorrectRequestDate() {

        RestAssured
                .given()
                .spec(defaultRequestSpecificationDateAndMath("Accept-Language", "ru", "/date"))
//                .header("Accept-Language", "ru")
//                .baseUri(NUMBERS_URL)
                .when()
                .get(idData)
                .then()
//                .log().all()
//                .statusCode(404);
                .spec(defaultResponseSpecification(404));
    }

    @DisplayName("Must have the correct math number 5 status line")
    @Test
    public void shouldHaveCorrectStatusCodeMath5() {

        Response response = RestAssured.given().get("http://numbersapi.com/#99999999/math");

        System.out.println("response.statusLine() = " + response.statusLine());

        Assertions.assertEquals(HTTP_200_OK, response.statusLine());
    }

    @DisplayName("Must have the correct content type date 8/30")
    @Test
    public void shouldHaveCorrectContentTypeDate8_30() {

        Response response = RestAssured.given().get("http://numbersapi.com/#8/30/date");

        System.out.println("response.contentType() = " + response.contentType());

        Assertions.assertEquals(CONTENT_TYPE, response.contentType());
    }

    @DisplayName("Checking the correctness of the Content-Type field display")
    @Test
    public void shouldHaveCorrect() {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("Accept-Language", "ru")
                .setBaseUri(NUMBERS_URL)
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                //.baseUri(NUMBERS_URL)
                //.param("id", 2)
                .when()
                //.get(ID_PATH)
                .get("/2")
                .then()
                .spec(responseSpecification);
        //.contentType(ContentType.TEXT)
        //.log().all()
        //.header("Content-Length", "67")
        //.statusCode(200);
    }

    @DisplayName("The check must have the correct Api type Date")
    @Test
    public void shouldHaveCorrectNumbersApiTypeMath() {

        RestAssured
                .given()
                .spec(defaultRequestSpecificationDateAndMath("Accept-Language", "ru", "/2/math"))
//                .header("Accept-Language", "ru")
//                .baseUri(NUMBERS_URL)
                .when()
                .get(idData)
//                .get("/2/math")
                .then()
//                .contentType(ContentType.TEXT)
//                .log().all()
//                .header("X-Numbers-API-Type", "math")
//                .statusCode(200);
                .spec(defaultResponseSpecification("X-Numbers-API-Type", "math", 200));
    }

    @DisplayName("The check must have the correct Api type Date")
    @Test
    public void shouldHaveCorrectApiTypeDate() {

        RestAssured
                .given()
                .spec(defaultRequestSpecificationDateAndMath("Content-Type", "text/plain; charset=utf-8", "/8/29/date"))
//                .header("Accept-Language", "ru")
//                .baseUri(NUMBERS_URL)
                .when()
                .get(idData)
//                .get("/8/29/date")
                .then()
//                .contentType(ContentType.TEXT)
//                .log().all()
//                .header("X-Numbers-API-Type", "date")
//                .statusCode(200)
                .spec(defaultResponseSpecification("X-Numbers-API-Type", "date", 200));
    }

    @DisplayName("Checking that the correct connection is correct")
    @Test
    public void shouldHaveCorrectConnection() {

        RestAssured
                .given()
                //.header("Content-Type", "text/plain; charset=utf-8")
                //.baseUri(NUMBERS_URL)
                //.pathParam("id", "8")
                .spec(defaultRequestSpecification("Content-Type", "text/plain; charset=utf-8", 8))
                .when()
                .get(String.valueOf(id))
                .then()
                //.contentType(ContentType.TEXT)
                //.log().all()
                //.header("Connection", "keep-alive")
                //.statusCode(200);
                .spec(defaultResponseSpecification("Connection", "keep-alive", 200));
    }

    @DisplayName("Checking the correctness of methods working through a class")
    @Test
    public void shouldHaveCorrectMethodThroughClass() {

        RestAssured
                .given()
                .spec(defaultRequestSpecification("Accept-Language", "fr", 100))
                .when()
                .get(String.valueOf(id))
                .then()
                .spec(defaultResponseSpecification("Connection", "keep-alive", 200));
    }
}

