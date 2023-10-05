package com.wipro.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTake {
	
	public static void takeScreenShot(WebDriver webdriver, String filename) {
    	TakesScreenshot srcshot = ((TakesScreenshot)webdriver);
    	File srcShotFile = srcshot.getScreenshotAs(OutputType.FILE);
    	File destFile = new File(System.getProperty("user.dir")+filename +".png");
    	try {
    		FileUtils.copyFile(srcShotFile, destFile);
    	
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }

}
