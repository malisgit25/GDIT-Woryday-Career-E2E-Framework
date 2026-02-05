package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyApplicationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	

	// Constractor

	private ApplyApplicationPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			
		}

	public void Test() {

	}

}
