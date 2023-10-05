package com.wipro.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();

	public static FileReader f1;
	public final Logger logs = Logger.getLogger(TestBase.class);
	public static ExtentReports report;
	public static ExtentTest test;

	
	@BeforeTest
	
	
	
	public void setUp() throws IOException {
		if(driver==null) {
			//FileReader f1 = new FileReader(System.getProperty("user.dir")+"//QET_CoE_SeleniumL21/src/test/resources/resources/config_files/test.properties");
			
			 f1 = new FileReader("C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources\\config_files\\test.properties");
			prop.load(f1);
			
			
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nutha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			 driver = new EdgeDriver();
			logs.info("chrome driver initialised");
			
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			logs.info("Nopcommerce was opened");
				
			}
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources/Reports.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
	}
	
	

	
	@AfterTest
	public void tearDown() {
		report.flush();
		driver.close();
		
		
	}
}
