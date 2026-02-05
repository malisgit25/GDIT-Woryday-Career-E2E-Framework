package com.gdit.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class searchAndClickFirstJob {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String SEARCH_URL = "https://www.gdit.com/careers/search/?q=Test%20Engineer";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testFirstGditSearchResult() {
        driver.get(SEARCH_URL);

        // Stable job card
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-automation-id='jobCard']")));

        WebElement firstCard = driver.findElements(By.cssSelector("div[data-automation-id='jobCard']")).get(0);

        WebElement titleEl = firstCard.findElement(By.cssSelector("a[data-automation-id='jobTitle']"));

        WebElement locationEl = firstCard.findElement(By.cssSelector("div[data-automation-id='locations']"));

        String title = titleEl.getText().trim();
        String link = titleEl.getAttribute("href");
        String location = locationEl.getText().trim();

        Assert.assertNotNull(title);
        Assert.assertFalse(title.isEmpty());
        Assert.assertTrue(link.startsWith("http"));
        Assert.assertFalse(location.isEmpty());

        System.out.println("First job title : " + title);
        System.out.println("First job link  : " + link);
        System.out.println("First job place : " + location);
    }
}