package com.gdit.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import com.gdit.utilities.WaitUtility;

public class Standalonetest {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gdit.wd5.myworkdayjobs.com/en-US/External_Career_Site/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-automation-id='email']")))
				.sendKeys("zaliva2010@hotmail.com");

		driver.findElement(By.cssSelector("input[data-automation-id='password']")).sendKeys("Gdit_2025");

		// Wait for Sign‑In button
		WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Sign In']")));
		signInBtn.click();

		// Click on Search and Apply button
		WebDriverWait waitforsearch = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement searchAndApply = waitforsearch.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[data-automation-id='navigationItem-Search and Apply']")));																						// page
		searchAndApply.click();

		// Enter text to search open positions
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-input")));
		search.sendKeys("Test Engineer");
		//driver.findElement(By.className("search-input")).sendKeys("Test Engineer");
		
		driver.findElement(By.id("submit-button")).click();

		// Click on the first link

		// find title element for the first job card
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement titleEl = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(@href,'/careers/job') and contains(@href,'engineer')]")));
		titleEl.click();
		
		//Click on Apply button
		
		WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/apply') and text()='Apply Now']")));
		apply.click();
		
		//driver.findElement(By.xpath("//a[contains(@href,'/apply') and text()='Apply Now']"));
		
		// verify text and click if it matches
		/*
		 * String title = titleEl.getText().trim(); titleEl.click();
		 * 
		 * if ("Test Engineer".equalsIgnoreCase(title)) {titleEl.click();}
		 * 
		 * else { System.out.println("First title is: " + title); }
		 * 
		 */
		// Wait until job cards are loaded
		/*
		 * WebDriverWait searchresult = new WebDriverWait(driver,
		 * Duration.ofSeconds(30));
		 * searchresult.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
		 * ("a[data-automation-id='jobTitle']")));
		 */

		// Find all job cards
		//List<WebElement> jobCards = driver.findElements(By.cssSelector("div[data-automation-id='jobCard']"));

		// Loop through and click the first matching job

		/*
		 * for (WebElement card : jobCards) { WebElement titleEl =
		 * card.findElement(By.cssSelector("a[data-automation-id='jobTitle']")); String
		 * title = titleEl.getText().trim();
		 * 
		 * if (title.equalsIgnoreCase("Test Engineer Senior")) { // Wait until clickable
		 * and click
		 * wait.until(ExpectedConditions.elementToBeClickable(titleEl)).click();
		 * System.out.println("Clicked on job: " + title); break; // stop after clicking
		 * the first match } }
		 */

		/*
		 * String targetTitle = "Test Engineer Senior";
		 * 
		 * for (WebElement card : jobCards) {
		 * 
		 * WebElement titleEl = card.findElement(
		 * By.cssSelector("a[data-automation-id='jobTitle']"));
		 * 
		 * String title = titleEl.getText().trim();
		 * 
		 * if (title.equalsIgnoreCase(targetTitle)) {
		 * wait.until(ExpectedConditions.elementToBeClickable(titleEl)).click();
		 * System.out.println("Clicked on job: " + title); break; } }
		 * 
		 */

		// Clickon Apply now button
		// driver.findElement(By.xpath("//*[@id=\"carers-job-summary-w-cta\"]/div[4]/a")).click();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * 
		 * // Username WebElement username =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))
		 * ); username.sendKeys("Admin");
		 * 
		 * // Password WebElement password =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))
		 * ); password.sendKeys("admin123");
		 * 
		 * // Login button WebElement loginBtn = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * "button[type='submit']"))); loginBtn.click();
		 */

		// =================================Break==============================================

		/*
		 * Use our custom WaitUtility (30 sec default) WaitUtility waitUtil = new
		 * WaitUtility(driver);
		 * 
		 * // Username WebElement username =
		 * waitUtil.waitForVisibility(By.name("username")); username.sendKeys("Admin");
		 * 
		 * // Password WebElement password =
		 * waitUtil.waitForVisibility(By.name("password"));
		 * password.sendKeys("admin123");
		 * 
		 * // Login button WebElement loginBtn =
		 * waitUtil.waitForClickability(By.cssSelector("button[type='submit']"));
		 * loginBtn.click();
		 */

	}
}
