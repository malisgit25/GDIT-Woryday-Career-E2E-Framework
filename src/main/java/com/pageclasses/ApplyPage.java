package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locator
	private By apply = By.xpath("//a[contains(@href,'/apply') and text()='Apply Now']");

	public ApplyPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public void clickonApplyButton() {
		
		WebElement applyb = wait.until(ExpectedConditions.elementToBeClickable(apply));
		applyb.click();
	}
	
}

