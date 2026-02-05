package com.gdit.listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gdit.basetest.Basetest;
import com.gdit.reporting.ExtentManager;


public class ExtentListener implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	private static ExtentReports extent = ExtentManager.createInstance();
	// public static ThreadLocal<ExtentTest> testReport = new
	// ThreadLocal<ExtentTest>();
	// public static ExtentTest test; //This will define all the logs inside your
	// test case.

	
	/*===Explanation on onTestStart method===
	 * create a new ExtentTest
	 * store it in ThreadLocal
	 * associate it with the current test thread
	 */	
	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent
				.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName());

		Basetest.setTest(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		Basetest.getTest().log(Status.PASS,
				MarkupHelper.createLabel("TEST CASE: " + methodName.toUpperCase() + " PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Basetest.getTest().fail(result.getThrowable());
		try {
			String base64 = ExtentManager.captureScreenshotAsBase64();
			Basetest.getTest().fail("Screenshot of failure",
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
		} catch (Exception e) {
		}
		Basetest.getTest().log(Status.FAIL, MarkupHelper.createLabel("TEST FAILED", ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Basetest.getTest().log(Status.SKIP, MarkupHelper.createLabel("TEST SKIPPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}



