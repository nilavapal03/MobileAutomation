package com.nilava.Appium.genericLib;

import java.io.IOException;

public class KillOldSession {
	
	public static void killOldAppiumSession() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
