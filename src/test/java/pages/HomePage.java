package pages;

import static utilities.DriverSetup.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	public WebElement dropDown;

	@AndroidFindBy(xpath = "//*[@text='Bangladesh']")
	public WebElement countryBD;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement nameInputField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	public WebElement genderFemale;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	public WebElement genderMale;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement submitButton;
	
	public void selectCountry(String name) {
		dropDown.click();
		scrollTotext(name);
		countryBD.click();
	}
	
	public void selectGender() {
		genderFemale.click();
	}
	
	public void enterName(String name) {
		nameInputField.sendKeys(name);
	}
	
}
