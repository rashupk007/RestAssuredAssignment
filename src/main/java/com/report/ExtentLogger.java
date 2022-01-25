package com.report;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void info(String message){
       ExtentManager.getExtentTest().info(message);
    }

    public static void logRequestAndResponse(Response response){
       // pass(SpecificationQuerier.query(requestSpecification).getBody().toString());
        pass(response.prettyPrint());
    }
}
