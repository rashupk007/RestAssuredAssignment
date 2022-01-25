package com.tests;

import com.report.ExtentLogger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IntigralOTTTests {

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"webB2BGDMSTGExy0sVDlZMzNDdUyZ"}
        };
    }



    @Test(dataProvider = "getData")
    public void testOTTResponse(String token) {

        Response response = RestAssured
                .given()
                .queryParam("apikey",token)
                .contentType(ContentType.JSON).log()
                .all()
                .get("https://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions");

        ExtentLogger.logRequestAndResponse(response);

        assertThat(response.jsonPath().getString("promotions[0].promotionId"))
                .isOfAnyClassIn(String.class);

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.jsonPath().getString("promotions[0].properties[0].programType"))
                .isOfAnyClassIn(String.class)
                .isIn(Arrays.asList("episode","movie","series","season"));

        JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/test/resources/jsonSchema.json"));


    }

    @DataProvider
    public static Object[][] getDataForInvalidScenario() {
        return new Object[][]{
                {"webB2BGDMSTGExy0sVDlZMzNDdUyZ1234"}
        };
    }

    @Test(dataProvider = "getDataForInvalidScenario")
    public void validateErrorOnInvalidToken(String token){
        Response response = RestAssured
                .given()
                .queryParam("apikey",token)
                .contentType(ContentType.JSON).log()
                .all()
                .get("https://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions");

        ExtentLogger.logRequestAndResponse(response);

        assertThat(response.getStatusCode()).isEqualTo(403);
        assertThat(response.jsonPath().getString("error.message")).isEqualTo("invalid api key");
        assertThat(response.jsonPath().getString("error.code")).isEqualTo("8001");
        assertThat(response.jsonPath().getString("error.requestId")).isNotBlank().isNotNull().isNotEmpty();

    }
}
