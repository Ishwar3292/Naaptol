package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ScreenShot;


public class Listener extends BaseTest implements ITestListener {
	

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test start:-"+result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test success:-"+result.getName());

	}
	public void onTestFailure(ITestResult result) {
		
		try {
			ScreenShot.clickScreenShot(driver, "Test failure;-"+result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped:-"+result.getName());
		
	}
	



}
