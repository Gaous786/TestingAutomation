package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class LoginPage extends BasePage {

	@FindBy(id = "emailAddress")
	private WebElement userNameTextBox;

	@FindBy(id = "password")
	private WebElement userPasswordTextBox;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement loginButton;
	
	

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public void loginToApplication(String userNameValue, String passwordValue) {

		super.sendKeys(userNameTextBox, "user name text box", userNameValue);
		super.sendKeys(userPasswordTextBox, "password text box", passwordValue);
		super.click(loginButton, "login button");

	}

}
