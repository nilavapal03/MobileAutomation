package com.nilava.Appium.ObjectRepo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nilava.Appium.genericLib.Driver;
import com.nilava.Appium.genericLib.ReusableMethod;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreLoginPage {

	ReusableMethod reuse = new ReusableMethod();

	@AndroidFindBy(id = "android:id/text1")
	private WebElement selectCountryFromDropdown;

	@AndroidFindBy(xpath = "//*[@text='Enter name here']")
	private WebElement enterNameHere;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement clickonSubmitButton;

	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	private WebElement toastMsg;

	// For bulk elemnets
	@AndroidFindBy(className="android.widget.RadioButton")
	private List<WebElement> clickonGender;

	public GeneralStoreLoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
	}

	public void selectCountryFromGeneralStoreApp() {
		selectCountryFromDropdown.click();

	}

	public void chooseCountry(String country) {
		Driver.driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.driver.findElement(By.xpath("//*[@text='" + country + "']")).click();
	}

	public void enterYourName(String valueName) {
		enterNameHere.sendKeys(valueName);

	}

	public void selectGender() {
		clickonGender.get(1).click();
	}

	public void submitapplicationButton() {
		clickonSubmitButton.click();
	}

	public String getToastMsg() {
		return toastMsg.getAttribute("name");
	}
}
