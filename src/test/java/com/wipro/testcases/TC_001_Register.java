package com.wipro.testcases;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wipro.testbase.*;
import com.wipro.utilities.ReadExcelFile;
import org.testng.internal.reflect.DataProviderMethodMatcher;
public class TC_001_Register extends TestBase
{
	@Test(dataProviderClass=ReadExcelFile.class,dataProvider="myTest")
	public static void Sheet1(String firstname, String lastname, String email, String password, String confirm_password) throws InterruptedException, IOException
	{	
		final Logger logs = Logger.getLogger(TestBase.class);
		ExtentTest test = report.createTest("Register1");
		Register_Elements obj1 = new Register_Elements();
		obj1.reg_Elements(firstname, lastname, email, password, confirm_password);
		//boolean errorMsg = obj1.usermailAlreadyExistError();
		if(obj1.usermailAlreadyExistError()) {
			try {
				Assert.assertFalse(obj1.usermailAlreadyExistError());
				
				
			} catch(AssertionError e) {
				takeScreenShot(driver, "ss-01-register");
				test.log(Status.FAIL, "user name already exists");
				logs.error(e + " User already registered with tha mail");
			}
		}
		else {
		test.log(Status.PASS, "Success");
		logs.info(email + " is registerd successfully");
		}
		Address1 obj = new Address1();
		obj.log_In(email, confirm_password);
		obj.logging_Out();
	}
	
	public static void takeScreenShot(WebDriver webdriver, String filename) {
    	TakesScreenshot srcshot = ((TakesScreenshot)webdriver);
    	File srcShotFile = srcshot.getScreenshotAs(OutputType.FILE);
    	File destFile = new File(System.getProperty("usr.dir")+ filename +"_"+System.currentTimeMillis()+".png");
    	try {
    		FileUtils.copyFile(srcShotFile, destFile);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }

}






