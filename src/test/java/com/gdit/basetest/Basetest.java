package com.gdit.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.gdit.reporting.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {


	// ThreadLocal WebDriver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// ThreadLocal ExtentTest (used by Listener)
	protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	// Config
	protected static Properties config = new Properties();

	// ExtentReports singleton
	protected static ExtentReports extent = ExtentManager.createInstance();

	// Logger
	protected static Logger log = LogManager.getLogger(Basetest.class);

	// WebDriver Getter
	public static WebDriver getDriver() {
		return driver.get();
	}

	// ExtentTest Getter 
	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}

	@BeforeSuite(alwaysRun = true)
	public void configureLog4j() {
		// Force Log4j2 to load configuration file
		System.setProperty("log4j.configurationFile",
				System.getProperty("user.dir") + "/src/test/resources/Log4j2/log4j2.xml");

		// Ensure the Logs folder exists
		File logDir = new File(System.getProperty("user.dir") + "/Logs");
		if (!logDir.exists()) {
			logDir.mkdirs();
		}

		log.info("Log4j2 configuration loaded and Logs folder verified/created.");
	}

	// Setup
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		log.info("===== Test Execution Started =====");

		// Load config inline
		if (config.isEmpty()) {
			try (FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties")) {
				config.load(fis);
				log.info("Config loaded successfully");
			} catch (IOException e) {
				log.error("Failed to load config.properties", e);
				throw new RuntimeException(e);
			}
		}

		String browser = config.getProperty("browser").trim().toLowerCase();

		log.info("Launching browser: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			log.error("Unsupported browser: " + browser);
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(config.getProperty("url"));
		log.info("Navigated to URL: " + config.getProperty("url"));
	}

	// Teardown

	/*
	 * @AfterMethod(alwaysRun = true) public void tearDown() { if (getDriver() !=
	 * null) { getDriver().quit(); driver.remove(); // prevent memory leaks
	 * test.remove(); } log.info("===== Test Execution Finished ====="); }
	 */

}



