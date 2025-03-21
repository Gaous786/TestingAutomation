package com.iframe;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class IframeActions {

	private Logger logger = LogManager.getLogger(IframeActions.class);

	public void waitForIframeAndSwitch(String idOrName) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));

			logger.info("Switched to iframe");

			ExtentFactory.getInstance().passTest("Switched to iframe");

		} catch (Exception e) {
			logger.error("Error occured while switching to iframe");
			ExtentFactory.getInstance().failTest("Error occured while switching to iframe");
		}

	}

	public void waitForIframeAndSwitch(int index) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

			logger.info("Switched to iframe");

			ExtentFactory.getInstance().passTest("Switched to iframe");

		} catch (Exception e) {
			logger.error("Error occured while switching to iframe");
			ExtentFactory.getInstance().failTest("Error occured while switching to iframe");
		}

	}

	public void switchBackToDefoultContent() {

		try {
			DriverFactory.getInstance().getDriver().switchTo().defaultContent();

			logger.info("Switched to the defoult content");

			ExtentFactory.getInstance().passTest("Switched to the defoult content");
		} catch (Exception e) {
			logger.error("Error occured while switching to the default content");
			ExtentFactory.getInstance().failTest("Error occured while switching to the default conten");
		}
	}

}
