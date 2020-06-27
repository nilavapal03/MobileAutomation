package com.nilava.Appium.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	public static Logger logger = Logger.getLogger(Driver.class);
	public static Properties prop = new Properties();
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {
		PropertyConfigurator.configure("./resourcesLib/configFile/log4j.properties");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {
			logger.info("=================Properties file loading======================");
			prop.load(new FileInputStream("./resourcesLib/configFile/config.properties"));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException While loading properties file", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException while fetch data from properties file", e);
			e.printStackTrace();
		}
		
		String deviceName=prop.getProperty("DeviceName");
		if(deviceName.contains("emulator")) {
			Emulator.startEmulator();
			
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 25);
		capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("apkFilePath"));

		try {
			logger.info("Hit Apppium URL ...");
			driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("RemoteURL")), capabilities);
		} catch (Exception e) {
			logger.error("Error while Hitting Appium URL", e);
			e.printStackTrace();
		}
		return driver;

	}

}
