package com.gdit.utilities;

	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WaitUtility {

		WebDriver driver;
		WebDriverWait wait;

		// Constructor with default timeout (30 sec)
		public WaitUtility(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		}

		// Constructor with custom timeout
		public WaitUtility(WebDriver driver, int timeoutInSeconds) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		}

		/** Wait for visibility */
		public WebElement waitForVisibility(By locator) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		/** Wait for clickability */
		public WebElement waitForClickability(By locator) {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		/** Wait for presence */
		public WebElement waitForPresence(By locator) {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

		/** Wait for text to be present inside element */
		public boolean waitForText(By locator, String text) {
			return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		}

		/** Wait for element to disappear */
		public boolean waitForInvisibility(By locator) {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}

	


}
