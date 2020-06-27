package com.nilava.Appium.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.nilava.Appium.genericLib.Driver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreNotificationsPage {

	@AndroidFindBy(className="android.widget.TextView")
	private List<AndroidElement> getNotifications;
	//
	
	
	@AndroidFindBy(xpath="//*[@text='Clear all']")
	private WebElement clearAll;
	
	public GeneralStoreNotificationsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
	}
	
	public void clickonClearAll() {
		if(clearAll.isEnabled()) {
			clearAll.click();
		}else {
			Driver.driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
	}
	
	public String getAllnotifications() {
		String allNotifications="";
		List<AndroidElement> list=getNotifications;
		for(int i=0;i<list.size();i++) {
			allNotifications=list.get(i).getText();
		}
		return allNotifications;
	}
}
