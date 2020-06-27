package com.nilava.Appium.genericLib;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ReusableMethod {
	
	
	public void scrollMobileUIPage(String value) {
		Driver.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\")")).click();
		//Driver.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\")")).click();
	}

	
	public void swapElements(String firstElement, String secondElement) {
		TouchAction action= new TouchAction(Driver.driver);
		WebElement wb1= Driver.driver.findElement(By.xpath(firstElement));
		WebElement wb2=Driver.driver.findElement(By.xpath(secondElement));
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(wb1)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(wb2)).release().perform();
	}
	
	public void dragAndDrop(String fristElements, String seconedElement) {
		TouchAction action= new TouchAction(Driver.driver);
		WebElement srcWb= Driver.driver.findElement(By.xpath(fristElements));
		WebElement destWb= Driver.driver.findElement(By.xpath(seconedElement));
		//action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(srcWb))).moveTo(ElementOption.element(destWb)).release().perform();
		
		action.longPress(ElementOption.element(srcWb)).moveTo(ElementOption.element(destWb)).release().perform();
	}
	
	public void switchToWebViewMode() {
		Set<String> set=Driver.driver.getContextHandles();
		Iterator<String> it = set.iterator();
		String nativeAPP=	it.next();
		String WEB_VIEWAPP= it.next();
		System.out.println("Native App is===========>"+nativeAPP);
		System.out.println("Native App is===========>"+WEB_VIEWAPP);
		if(nativeAPP.equalsIgnoreCase("NATIVE_APP")) {
				Driver.driver.context(nativeAPP);
		}else {
			Driver.driver.context(WEB_VIEWAPP);
		}
		
		}
}
