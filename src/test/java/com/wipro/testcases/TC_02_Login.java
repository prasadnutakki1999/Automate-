package com.wipro.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wipro.testbase.Address;
import com.wipro.testbase.Address1;
import com.wipro.testbase.TestBase;
import com.wipro.utilities.ReadExcelFile;

public class TC_02_Login extends TestBase{
	@Test(dataProviderClass=ReadExcelFile.class, dataProvider="myTest")
	public static void sheet2(String email, String password, String fname, String lname, String country, String city, String address1, String postalcode, String phonenumber) throws InterruptedException, IOException {

		final Logger logs = Logger.getLogger(TestBase.class);
		ExtentTest test = report.createTest("Login");
		Address1 obj = new Address1();
		try {
			Assert.assertFalse(obj.loginErrors());
		}catch(AssertionError e) {
			takeScreenShot(driver, "ss-02-login");
			test.log(Status.FAIL, "email validation error");
		}catch(Exception e) {
			Thread.sleep(1000);
			takeScreenShot(driver, "ss-02-login");
			logs.info(e + " Empty fields in address filling box");
			test.log(Status.FAIL, "Address box was empty");
		}
		obj.log_In(email, password);
		obj.add_Addresses(email, fname, lname, country, city, address1, postalcode, phonenumber);
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
