package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyManuallyPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locators
	public By applyManuallyButton = By.cssSelector("a[data-automation-id='applyManually']");

	
	
	//Constractor
	
	public ApplyManuallyPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}
	
	public void clickOnApplyManuallyButton() {
		WebElement manualapply = wait.until(ExpectedConditions.elementToBeClickable(applyManuallyButton));
		manualapply.click();
		
		
	}

}
