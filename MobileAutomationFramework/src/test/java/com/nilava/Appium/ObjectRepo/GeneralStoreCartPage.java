package com.nilava.Appium.ObjectRepo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.nilava.Appium.genericLib.Driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class GeneralStoreCartPage {

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement readsOurTermsAndConditionButton;

	@AndroidFindBy(xpath = "//*[@text='CLOSE']")
	private WebElement clickOncloseButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement clickOnCheckOutButton;

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement googleSearchbox;

	@AndroidFindBy(className = "android.widget.Button")
	private WebElement clickonSearchButton;

	// Bulk elements

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<AndroidElement> productsName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<AndroidElement> productsPrice;

	

	public GeneralStoreCartPage() {
		PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
	}

	public String getProductDetails(String productName) {

		return Driver.driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName + "']")).getText();

	}

	public String getPriceDetails(String expectedProduct) {
		String priceDetails = "";
		List<AndroidElement> list1 = productsName;
		for (int i = 0; i < list1.size(); i++) {
			String actualproduct = list1.get(i).getText();
			System.out.println("Actual Product is ======>" + actualproduct);
			if (expectedProduct.equalsIgnoreCase(actualproduct)) {
				priceDetails = productsPrice.get(i).getText();
				break;
			}

		}
		return priceDetails;
	}

	public String totalPurchaseAmount() {
		return totalPurchaseAmount.getText();
	}

	public String pleaseReadOurTermsAndConditionText() {
		return readsOurTermsAndConditionButton.getText();
	}

	public void pleaseReadOurTermsAndConditionButton(String text) {
		WebElement wb = Driver.driver.findElement(MobileBy.AndroidUIAutomator("text(\"" + text + "\")"));
		TouchAction action = new TouchAction(Driver.driver);
		action.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(3))
				.withElement(ElementOption.element(wb))).release().perform();

		if (clickOncloseButton.isEnabled()) {
			clickOncloseButton.click();
		} else {
			System.out.println("CLOSE Button is not enabled");
		}

	}

	public void tapcheckBox() {
		WebElement wb = Driver.driver.findElement(MobileBy
				.AndroidUIAutomator("text(\"Send me e-mails on discounts related to selected products in future\")"));
		TouchAction action = new TouchAction(Driver.driver);
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(wb))).perform();

	}

	public void clickoncheckoutButton() {
		clickOnCheckOutButton.click();
	}

	public void searchBox(String value) {
		googleSearchbox.sendKeys(value);
	}

	public void clickonSearchButton() {
		clickonSearchButton.click();
	}
}
