package com.listeners;

import com.report.ExtentLogger;
import com.report.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.info(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().getMessage() );
        ExtentLogger.info(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }



}
