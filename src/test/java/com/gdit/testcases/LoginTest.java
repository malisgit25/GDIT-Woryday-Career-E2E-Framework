package com.gdit.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ParaBank.pages.ScreenShotPage;
import com.aventstack.extentreports.Status;
import com.gdit.basetest.Basetest;
import com.gdit.utilities.DataDrivernUtility;
import com.pageclasses.ApplyManuallyPage;
import com.pageclasses.ApplyPage;
import com.pageclasses.LoginPage;
import com.pageclasses.MyExperiencePage;
import com.pageclasses.MyInformationPage;
import com.pageclasses.SearchAndApplyPage;

public class LoginTest extends Basetest {

	@DataProvider(name = "getdata")
	public Object[][] getdata() {
		return DataDrivernUtility.getdata("logindata");
	}

	@Test(dataProvider = "getdata", description = "Logitest")
	public void Login(String emailaddress, String password) {
		ScreenShotPage screenshot = new ScreenShotPage(getDriver());

		LoginPage login = new LoginPage(getDriver());
		SearchAndApplyPage search = new SearchAndApplyPage(getDriver());
		ApplyPage apply = new ApplyPage(getDriver());
		ApplyManuallyPage manualapply = new ApplyManuallyPage(getDriver());
		MyInformationPage forminfo = new MyInformationPage(getDriver());
		//MyExperiencePage exp = new MyExperiencePage(getDriver());

		// Take login page screenshot-first wait for the page
		login.waitForLoginPage();
		screenshot.LoginPageScreenShot();
		// --Login---//
		// test.get().log(Status.INFO, "Entering Email Address: " + emailaddress);
		login.enterEmailAddress(emailaddress);
		// test.get().log(Status.INFO, "Entered username: " + emailaddress);

		test.get().log(Status.INFO, "Enter username");

		login.enterPassword(password);
		// test.get().log(Status.INFO, "Entered password: " + password);
		test.get().log(Status.INFO, "Enter password");

		login.clickOnSignInButton();
		test.get().log(Status.INFO, "Clicked on SignIn button");

		// --Assertion---
		/*
		 * Assert.assertTrue(getDriver().getCurrentUrl().contains("search"),
		 * "Login failed: User not redirected after clicking Sign In");
		 */

		// --Take homepage screenshot--
		/*
		 * login.waitForHomePage(); screenshot.HomePageScreenShot();
		 */

		// --Search---//
		search.clickonSearchAndApplyButton();
		test.get().log(Status.INFO, "Click on Search And Apply Button");
		search.waitForSearchPage();
		screenshot.Searchpage();
		search.searchForJob();
		test.get().log(Status.INFO, "Search for Job");

		search.clickOnJobTitle();
		test.get().log(Status.INFO, "Click on Job Title");

		apply.clickonApplyButton();
		test.get().log(Status.INFO, "Click on Apply Button");

		manualapply.clickOnApplyManuallyButton();
		test.get().log(Status.INFO, "Click on Apply Manually Button");

		// Form info
		forminfo.enterfirstname();
		test.get().log(Status.INFO, "Enter First Name");

		forminfo.enterlastname();
		test.get().log(Status.INFO, "Enter Last Name");
		forminfo.enterAddressline1();
		test.get().log(Status.INFO, "Enter Addressline1 Name");

		// Click Save and Continue WITHOUT resume
		forminfo.clickonSsaveAndContinueButton();
		test.get().log(Status.INFO, "Click On Save And Continue Button");
		// Verify resume error appears

		/*
		 * 1. Click Save and Continue 2. Verify resume error appears 3. Upload resume 4.
		 * Click Save and Continue 5. Verify navigation to next page
		 */

		//test.get().log(Status.PASS, "Login Test Completed");

	}

}
