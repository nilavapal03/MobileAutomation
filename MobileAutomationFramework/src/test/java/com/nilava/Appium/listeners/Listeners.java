package com.nilava.Appium.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nilava.Appium.genericLib.AppiumServer;
import com.nilava.Appium.genericLib.Emulator;
import com.nilava.Appium.genericLib.KillOldSession;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Mobile Testing on Test Start ");
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Mobile Testing on Test Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Mobile Testing on Test Failure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Mobile Testing on Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Mobile Testing on Test with Success Percentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Mobile Testing on Test with context");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Emulator.stopEmulator();
		System.out.println("Mobile Testing on Test Finish");
		
	}

}
