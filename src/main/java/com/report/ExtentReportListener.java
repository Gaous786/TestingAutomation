package com.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener {

	private static Logger logger = LogManager.getFormatterLogger(ExtentReportListener.class);

	private ExtentReports extentReport;

	private ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		this.extentTest = extentReport.createTest(result.getName());
		ExtentFactory.getInstance().setExtent(extentTest);
		logger.info("Test is added in pool");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().passTest(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().fail("Exception details " + result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, " test case " + result.getName() + "is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		this.extentReport = ExtentReportManager.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		this.extentReport.flush();
	}

}
