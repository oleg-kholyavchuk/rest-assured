package ru.buttonone.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NumbersSpecifications {

    public static final String NUMBERS_URI = "http://numbersapi.com";
    public static int id;
    public static String idDate;

    public static RequestSpecification defaultRequestSpecification(String headerName, String headerValue, int idTest) {

        id = idTest;

        return new RequestSpecBuilder()
                .addHeader(headerName, headerValue)
                .setBaseUri(NUMBERS_URI)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification defaultRequestSpecificationDateAndMath(String headerName, String headerValue, String date) {

        idDate = date;

        return new RequestSpecBuilder()
                .addHeader(headerName, headerValue)
                .setBaseUri(NUMBERS_URI)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification defaultResponseSpecification(String headerName, String expectedValue, int statusCode) {

        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.TEXT)
                .expectHeader(headerName, expectedValue)
                .expectStatusCode(statusCode)
                .build();
    }

    public static ResponseSpecification defaultResponseSpecification(int statusCode) {

        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(statusCode)
                .build();
    }
}
