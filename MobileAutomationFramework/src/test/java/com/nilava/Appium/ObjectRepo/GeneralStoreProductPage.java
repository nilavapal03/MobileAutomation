package com.nilava.Appium.ObjectRepo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.nilava.Appium.genericLib.Driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreProductPage {
	
	@AndroidFindBy(xpath="//*[@text='PG 3']")
	private WebElement searchforPG3Product;

	@AndroidFindBy(xpath="//*[@text='Jordan 6 Rings']")
	private WebElement clickonJordan6Rings;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private WebElement productPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addCrat;
	

	//for bulk elements
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private WebElement addCartLink1;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<AndroidElement> addCartLink;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<AndroidElement> listOfProduct;
	
	
	
	public GeneralStoreProductPage() {
		PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
	}
	
	
	
	public void searchforPG3Products(String product) {
		Driver.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\""+product+"\"))"));
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	public String getPriceDetailsForProduct() {
		return productPrice.getText();
	}
	
	public void addCartlinkForProduct() {
		addCartLink1.click();
	}
	
	public void clickOnPG3Products() {
		searchforPG3Product.click();
	}
	
	public void clickonJordan6RingsProducts() {
		clickonJordan6Rings.click();
	}
	
	public void listOfItemScroll(String productName) {
		Driver.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\""+productName+"\"))"));
	}
	
	public void clickonAddCartIconfromProductPage() {
		addCrat.click();
	}

	
	public void searchForAnyProductAndClickOnProduct(String product) throws InterruptedException {
		Driver.driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
						+ product + "\").instance(0))"));
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<AndroidElement> lst = listOfProduct;
		for (int i = 0; i < lst.size(); i++) {
			String productName = lst.get(i).getText();
			System.out.println("Product name is::=========>" + lst.get(i).getText());
			if (product.equalsIgnoreCase(productName)) {
				System.out.println(lst.get(i).getText());
				Thread.sleep(2000);
				addCartLink.get(i).click();
				break;
			} 
		}
	}
}
