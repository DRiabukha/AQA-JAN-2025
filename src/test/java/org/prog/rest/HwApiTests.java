package org.prog.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwApiTests {

    @Test
    public void apiTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat, location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "1");

        Response response = requestSpecification.get();
        response.prettyPrint();


        ValidatableResponse validatableResponse = response.then();
        validatableResponse.body("results[0].location.city", Matchers.notNullValue());


        String value = response.jsonPath().get("results[0].location.city");
        Assert.assertNotNull(value, "location.city value should not be null");
    }
}
