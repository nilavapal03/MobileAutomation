package com.nilava.Appium.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Emulator {
	
	public static Properties prop= new Properties();
	
	public static void startEmulator() throws InterruptedException{
		
		try {
			prop.load(new FileInputStream("./resourcesLib/configFile/config.properties"));
			Runtime.getRuntime().exec(prop.getProperty("StartEmulator"));
			Thread.sleep(7000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopEmulator() {
		try {
			prop.load(new FileInputStream("./resourcesLib/configFile/config.properties"));
			Runtime.getRuntime().exec(prop.getProperty("StopEmulator"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
