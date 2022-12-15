package utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverSetup {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeSuite
	public static synchronized void setAndroidDriver() throws MalformedURLException {
		File f = new File("src");
		File fs = new File(f, "General-Store.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:udid", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appium:appPackage", "com.androidsample.generalstore");
		cap.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		setDriver(driver);
	}

	@AfterSuite
	public static synchronized void quitDriver() {
		getDriver().quit();
	}

	@SuppressWarnings("unchecked")
	public static AndroidDriver<WebElement> getDriver() {
		return (AndroidDriver<WebElement>) driver.get();
	}

	public static void setDriver(WebDriver driver) {
		DriverSetup.driver.set(driver);
	}
}
