package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInformationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	public By firstname = By.id("name--legalName--firstName");
	public By lastname = By.id("name--legalName--lastName");
	public By addressline1 = By.id("address--addressLine1");
	public By city = By.id("address--city");
	public By state = By.id("address--countryRegion");
	public By postalcode = By.id("address--postalCode");
	public By county = By.id("address--regionSubdivision1");
	public By phonedevicetype = By.id("phoneNumber--phoneType");
	public By phonenumber = By.id("phoneNumber--phoneNumber");
	public By saveandcontinue = By.cssSelector("button[data-automation-id='pageFooterNextButton']");

	public MyInformationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	}

	public void enterfirstname() {
		driver.findElement(firstname).sendKeys("Md");

	}

	public void enterlastname() {
		driver.findElement(lastname).sendKeys("Ali");

	}

	public void enterAddressline1() {
		driver.findElement(addressline1).sendKeys("1234 test");

	}

	public void enterCity() {
		driver.findElement(city).sendKeys("Reston");

	}

	public void enterState() {

	}

	public void enterPostalcode() {

	}

	public void enterCounty() {

	}

	public void selectPhoneDeviceType() {

	}

	public void enterPhonenumber() {

	}

	public void clickonSsaveAndContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveandcontinue)).click();

	}

}
