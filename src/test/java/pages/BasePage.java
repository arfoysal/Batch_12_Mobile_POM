package pages;
import static utilities.DriverSetup.getDriver;


public class BasePage {
	
	public void scrollTotext(String text) {
		(getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + text +"\"));");
	}

}
