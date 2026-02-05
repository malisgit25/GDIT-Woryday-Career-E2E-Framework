package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyExperiencePage {
	WebDriver driver;
	WebDriverWait wait;

	public By saveAndContinueBtn = By.xpath("//button[normalize-space()='Save and Continue']");
	
	public MyExperiencePage(WebDriver dirver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clicOnSaveAndContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueBtn)).click();
	}
	
}
