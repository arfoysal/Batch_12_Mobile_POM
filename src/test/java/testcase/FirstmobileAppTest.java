package testcase;

import org.testng.annotations.Test;

import pages.HomePage;
import utilities.DriverSetup;

public class FirstmobileAppTest extends DriverSetup {

	@Test
	public void homePageTest() throws InterruptedException {
		HomePage homePage = new HomePage();
		Thread.sleep(5000);
		homePage.selectCountry("Bangladesh");
		Thread.sleep(3000);
		homePage.enterName("Bangladesh");
		homePage.selectGender();
		homePage.submitButton.click();
		Thread.sleep(5000);
	}
}
