package stepDefination;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.nilava.Appium.ObjectRepo.GeneralStoreCartPage;
import com.nilava.Appium.ObjectRepo.GeneralStoreLoginPage;
import com.nilava.Appium.ObjectRepo.GeneralStoreNotificationsPage;
import com.nilava.Appium.ObjectRepo.GeneralStoreProductPage;
import com.nilava.Appium.genericLib.Driver;
import com.nilava.Appium.genericLib.ReusableMethod;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class General_Store_Step {
	//============Starts Objects initialization============//
	GeneralStoreLoginPage loginPage;
	GeneralStoreProductPage productPage;
	GeneralStoreCartPage cartPage;
	GeneralStoreNotificationsPage notificationsPage;
	ReusableMethod reuse;
	//============Ends Objects initialization============//
	
	
	
	@Given("^launch general Store hybrid App$")
	public void launch_general_Store_hybrid_App() throws IOException, InterruptedException{
		Driver.capabilities();
		Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^select the country where you want to shop$")
	public void select_the_country_where_you_want_to_shop() {
		loginPage = new GeneralStoreLoginPage();
		loginPage.selectCountryFromGeneralStoreApp();
		loginPage.chooseCountry("India");

	}

	@Then("^enter your name$")
	public void enter_your_name() throws Throwable {
		loginPage = new GeneralStoreLoginPage();
		loginPage.enterYourName("Nilava");

	}

	@Then("^select your gender$")
	public void select_your_gender() throws Throwable {
		loginPage = new GeneralStoreLoginPage();
		loginPage.selectGender();

	}

	@Then("^click on Let's shop button$")
	public void click_on_Let_s_shop_button() throws Throwable {
		loginPage = new GeneralStoreLoginPage();
		loginPage.submitapplicationButton();
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}
	
	
	@Then("^search for PG3 product$")
	public void search_for_PG_product() throws InterruptedException  {
		productPage= new GeneralStoreProductPage();
		Thread.sleep(3000);
		productPage.searchForAnyProductAndClickOnProduct("Jordan Lift Off");
	    
	}
	
	@Then("^search for product \"([^\"]*)\"$")
	public void search_for_product(String products) throws Throwable {
	    productPage= new GeneralStoreProductPage();
	    Thread.sleep(2000);
	    productPage.searchForAnyProductAndClickOnProduct(products);
	    
	}

	
	@Then("^fetch the product price from product$")
	public void fetch_the_product_price_from_product() throws Throwable {
		productPage= new GeneralStoreProductPage();
		String price=productPage.getPriceDetailsForProduct();
		System.out.println("Product price details is:: "+price);
	}

	@Then("^click on Add to cart link$")
	public void click_on_Add_to_cart_link() throws Throwable {
		productPage= new GeneralStoreProductPage();
		productPage.addCartlinkForProduct();
	}
	
	@Then("^verify Toast message from UI$")
	public void verify_Toast_message_from_UI() throws Throwable {
	    loginPage= new GeneralStoreLoginPage();
	    String toastMsg=loginPage.getToastMsg();
	    System.out.println("Toast Message is=============>"+toastMsg);
	    Assert.assertEquals("Please enter your name", toastMsg);
	}
	
	
	@Then("^search list of product and find out \"([^\"]*)\"$")
	public void search_list_of_product_and_find_out(String product) throws Throwable {
		productPage= new GeneralStoreProductPage();
		productPage.listOfItemScroll(product);
	   
	}
	
	@Then("^click on Add cart link$")
	public void click_on_Add_cart_link() throws Throwable {
		productPage= new GeneralStoreProductPage();
		productPage.clickonAddCartIconfromProductPage();
	    
	}
	
	
	@Then("^verify two product are available in cart page$")
	public void verify_two_product_are_available_in_cart_page() throws Throwable {
		cartPage=new GeneralStoreCartPage();
		String firststproduct=cartPage.getProductDetails("Jordan Lift Off");
		String sconedProduct=cartPage.getProductDetails("Converse All Star");
		System.out.println("First product Name is:: "+firststproduct);
		System.out.println("First product Name is:: "+sconedProduct);
		
	}

	@Then("^sum of two product amount is same as Total Purchase Amount$")
	public void sum_of_two_product_amount_is_same_as_Total_Purchase_Amount() throws Throwable {
		cartPage=new GeneralStoreCartPage();
		String price1=cartPage.getPriceDetails("Jordan Lift Off");
		String price2=cartPage.getPriceDetails("Converse All Star");
		System.out.println("Jordan Lift Off Price details is=======>"+price1);
		System.out.println("Converse All Star Price details is=======>"+price2);
		
		String p1=price1.substring(1);
		System.out.println("Price1 amount is===========>"+p1);
		float f1=Float.parseFloat(p1);
		
		
		String p2=price2.substring(1);
		System.out.println("Price1 amount is===========>"+p2);
		float f2=Float.parseFloat(p2);;
		float totalAmount=f1+f2;
		
		
		String finalTotalAmount=String.valueOf(totalAmount);
		System.out.println("totalAmount============>"+totalAmount);
		
		String tAmount="$ "+finalTotalAmount;
		
		
		String totalPurchase=cartPage.totalPurchaseAmount();
		
		
		System.out.println("totalPurchase========>"+totalPurchase);
		org.testng.Assert.assertEquals(totalPurchase, tAmount);
		
		
	}
	
	
	@Then("^Open notification from mobile$")
	public void open_notification_from_mobile() throws Throwable {
	    Driver.driver.openNotifications();
	}

	@Then("^find all notification$")
	public void find_all_notification() throws Throwable {
		notificationsPage= new GeneralStoreNotificationsPage();
		String notifications=notificationsPage.getAllnotifications();
		System.out.println("Notifications are ===========> "+notifications);
	}
	
	@Then("^clear the all notifications from mobile phone$")
	public void clear_the_all_notifications_from_mobile_phone() throws Throwable {
		notificationsPage= new GeneralStoreNotificationsPage();
		
		notificationsPage.clickonClearAll();
	}
	
	@Then("^click on \"([^\"]*)\" link$")
	public void click_on_link(String expectedText) throws Throwable {
		cartPage=new GeneralStoreCartPage();
		String actualText=cartPage.pleaseReadOurTermsAndConditionText();
		if(actualText.equalsIgnoreCase(expectedText)) {
			cartPage.pleaseReadOurTermsAndConditionButton(actualText);
		}
	}

	@Then("^click on checkbox from Total purchase amount page$")
	public void click_on_checkbox_from_Total_purchase_amount_page() throws Throwable {
	    cartPage= new GeneralStoreCartPage();
	    cartPage.tapcheckBox();
	}

	@Then("^click on Visit to the website to complete purchase button$")
	public void click_on_Visit_to_the_website_to_complete_purchase_button() throws Throwable {
		cartPage= new GeneralStoreCartPage();
		cartPage.clickoncheckoutButton();
	}

	@Then("^It will navigate to WEB-VIEW APP$")
	public void it_will_navigate_to_WEB_VIEW_APP() throws Throwable {
		Thread.sleep(8000);
		reuse= new ReusableMethod();
		reuse.switchToWebViewMode();
	}

	@Then("^Perform some operation inside the WEB-VIEW APP$")
	public void perform_some_operation_inside_the_WEB_VIEW_APP() throws Throwable {
	    cartPage= new GeneralStoreCartPage();
	    cartPage.searchBox("Appium");
	    cartPage.clickonSearchButton();
	    }
	
	@Then("^Again Navigate to NativeApp$")
	public void again_Navigate_to_NativeApp() throws Throwable {
	    Driver.driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(7000);
	    reuse.switchToWebViewMode();
	    loginPage = new GeneralStoreLoginPage();
		loginPage.enterYourName("Anuradha");
	    }
	
	
}
