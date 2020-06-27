package com.nilava.Appium.genericLib;

import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class AppiumServer {
	
	public static AppiumDriverLocalService service;
	public static AppiumDriverLocalService startAppiumServer() {
		boolean serverisRunning=checkIfServerIsRunning(4723);
		if(!serverisRunning) {
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
            }
		return service;
	}
	
	public static void stopAppiumServer() {
		if(service!=null) {
		service.stop();
		}
	}
	
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}catch (Exception e) {
			isServerRunning=true;
			
		}finally {
			serverSocket=null;
		}
		return isServerRunning;
	}
	
}
