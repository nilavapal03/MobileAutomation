package com.nilava.Appium.Runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.nilava.Appium.genericLib.AppiumServer;
import com.nilava.Appium.genericLib.Driver;
import com.nilava.Appium.genericLib.Emulator;
import com.nilava.Appium.genericLib.KillOldSession;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features="./resourcesLib/featuresFile",glue= {"stepDefination"}
,dryRun=false ,monochrome=true,
plugin= {"pretty","html:./report","json:./report/cucumber.json","junit:./report/cucumber.xml","json:./report/cucumber-reports/CucumberTestReport.json"}
,tags="@Addcart")

 

public class TestRunner extends AbstractTestNGCucumberTests {
	
public static Logger log= Logger.getLogger(TestRunner.class);

//@BeforeTest
//public void setUp() {
//	KillOldSession.killOldAppiumSession();
//}
//
//@AfterTest
//public void tearDown() {
//	Emulator.stopEmulator();
//}

@BeforeClass
public void startServer() throws InterruptedException {
	AppiumServer.startAppiumServer();
	
}

@AfterClass
public void stopServer() {
	if(Driver.driver!=null) {
		Driver.driver.quit();
		AppiumServer.stopAppiumServer();
	}
	
	
	}

}
