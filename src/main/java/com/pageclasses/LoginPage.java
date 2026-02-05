package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	public By EmailAddress = By.cssSelector("input[data-automation-id='email']");
	public By Password = By.cssSelector("input[data-automation-id='password']");
	public By SignIn = By.cssSelector("div[aria-label='Sign In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	//PAGE READINESS (wait for login page to render)
	public void waitForLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddress));
    }


	public void enterEmailAddress(String emailaddress) {
		// Add log4j log here later on
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddress)).sendKeys(emailaddress);

	}

	public void enterPassword(String password) {
		// Add log4j log here later on
		wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys(password);

	}
	
	public void clickOnSignInButton() {
	    // Wait for div to be visible and enabled
	    WebElement signInBtn = wait.until(driver -> {
	        WebElement el = driver.findElement(SignIn);
	        return (el.isDisplayed() && el.isEnabled() && el.getSize().getHeight() > 0 && el.getSize().getWidth() > 0) ? el : null;
	    });

	    // Optional tiny sleep for React rendering
	    try { Thread.sleep(300); } catch (InterruptedException e) {}

	    // JS click
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInBtn);
	}

	public void waitForHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn));
    }
	
	/*
	 * public void clickOnSignInButton() { // Wait until the Sign In div is present,
	 * visible, enabled, and fully rendered WebElement signInBtn = wait.until(driver
	 * -> { WebElement el = driver.findElement(SignIn); return (el.isDisplayed() &&
	 * el.isEnabled() && el.getSize().getHeight() > 0 && el.getSize().getWidth() >
	 * 0) ? el : null; });
	 * 
	 * // Click via JavaScript (ensures React synthetic event is triggered)
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * signInBtn); }
	 */

	
	/*
	 * public void clickOnSignInButton() { int retries = 5;
	 * 
	 * while (retries > 0) { try { // Wait for the Sign In div to be visible
	 * WebElement signInBtn = wait.until(driver -> { WebElement el =
	 * driver.findElement(SignIn); return (el.isDisplayed() && el.isEnabled() &&
	 * el.getSize().getHeight() > 0 && el.getSize().getWidth() > 0) ? el : null; });
	 * 
	 * // Move to element using Actions and click Actions actions = new
	 * Actions(driver); actions.moveToElement(signInBtn).click().perform();
	 * 
	 * // If no exception, click succeeded break;
	 * 
	 * } catch (Exception e) { // Wait 1 second and retry try { Thread.sleep(1000);
	 * } catch (InterruptedException ex) { } retries--; } }
	 * 
	 * if (retries == 0) { throw new
	 * RuntimeException("Unable to click on Sign In button after multiple retries");
	 * } }
	 */
	
	/*
	 * public void clickOnSignInButton() { // Wait until the Sign In div is visible
	 * and enabled WebElement signInBtn = wait.until(driver -> { WebElement el =
	 * driver.findElement(SignIn); return (el.isDisplayed() && el.isEnabled()) ? el
	 * : null; });
	 * 
	 * // Scroll into view ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", signInBtn);
	 * 
	 * // Ensure element is in viewport and stable wait.until(driver ->
	 * signInBtn.isDisplayed() && signInBtn.isEnabled());
	 * 
	 * // JavaScript click ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", signInBtn); }
	 */



	/*
	 * public void clickOnSignInButton() { WebElement signInBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(SignIn));
	 * 
	 * Actions action = new Actions(driver);
	 * action.moveToElement(signInBtn).click().perform(); }
	 */

	/*
	 * public void clickOnSignInButton() { WebElement signInBtn =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn));
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].focus();", signInBtn);
	 * js.executeScript("arguments[0].click();", signInBtn);
	 * 
	 * }
	 */
	/*
	 * public void clickOnSignInButton() { WebElement signInBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(SignIn));
	 * signInBtn.click(); }
	 */

	/*
	 * // JS click ensures React event fires reliably ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", signInBtn); }
	 */

	/*
	 * public void clickOnSignInButton() { // Add log4j log here later on
	 * wait.until(ExpectedConditions.elementToBeClickable(SignIn)).click();
	 * 
	 * }
	 */

	/*
	 * public void clickOnSignInButton() { WebElement signIn =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn));
	 * signIn.click(); }
	 */

	/*
	 * public void clickOnSignInButton() { wait.until(driver -> { WebElement
	 * signInBtn = driver.findElement(SignIn); if (signInBtn.isDisplayed() &&
	 * signInBtn.isEnabled()) { signInBtn.click(); return true; } else { return
	 * false; } }); }
	 */

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	/*
	 * public boolean isLoginSuccessful() { return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(SearchAndApplyBtn)).
	 * isDisplayed(); }
	 */
}
