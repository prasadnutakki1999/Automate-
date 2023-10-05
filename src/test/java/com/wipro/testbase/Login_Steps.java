package com.wipro.testbase;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@RunWith(Cucumber.class)
public class Login_Steps {
WebDriver driver;
WebElement user, pwd;
String temp;
List<WebElement> links;
public final static Logger logs = Logger.getLogger(TestBase.class);
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;
    @Given("^open (.+) and navigate to (.+)$")
    public void open_and_navigate_to(String browser, String page)  {
    	
    	if (browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/Users/NU20463617/Downloads/chromedriver_mac_arm64/chromedriver");
			//driver = new ChromeDriver();
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(page);
		}

		else if(browser.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.edge.driver", "/Users/NU20463617/Downloads/msedgedriver");
			//driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			driver.manage().window().maximize();
			driver.get(page);
		}
    	htmlReporter =  new ExtentHtmlReporter("/Users/NU20463617/eclipse-workspace/QET_CoE_SeleniumL21/src/test/resources/CucumberReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent =new ExtentReports();
     
        extent.attachReporter(htmlReporter); 
        test = extent.createTest("Cucumber TestCase");
       
    }

    @When("^user enters (.+) and (.+)$")
    public void user_enters_and(String username, String password)  {
    	driver.findElement(By.xpath("//a[@class='ico-login']")).click();
    	 user = driver.findElement(By.id("Email"));
    	user.sendKeys(username);
    	 pwd = driver.findElement(By.id("Password"));
    	pwd.sendKeys(password);
    	 
    }
    
    
    @And("^clicks on login button$")
    public void clicks_on_login_button() throws InterruptedException  {
    	driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
    	Thread.sleep(2000);
    	takeScreenShot(driver, "ss-01-login_clicked");
    	logs.info("Screenshot for login");
    	test.log(Status.PASS, "loginpassed");
    	Thread.sleep(3000);
    }

    
    @When("^expected title of page matches with resulted page$")
    public void expected_title_of_page_matches_with_resulted_page()  {
    	
    	String title = driver.getTitle();
    	Assert.assertEquals("nopCommerce demo store", title);
        
    }


    @And("^print and count the all menu links$")
    public void print_and_count_the_all_menu_links()  
    {
    	
    	
    	links = driver.findElements(By.xpath("//div[@class='header-menu']/ul[@class='top-menu notmobile']/li/a"));
    	//System.out.println(links.size());
    	String s = ""+links.size();
		String s1="";
		for(WebElement link:links) {
			//System.out.println(link.getAttribute("href"));
			  s1+= link.getAttribute("href");
			 
		}
		 temp =s+" "+s1;
		File F = new File("/Users/NU20463617/eclipse-workspace/QET_CoE_SeleniumL21/src/test/resources/resources/testdata/TC_04_test.txt");
		try {
			FileUtils.writeStringToFile(F, temp,Charset.defaultCharset());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }

    @And("^click on each menu link$")
    public void click_on_each_menu_link() throws InterruptedException  {

    	
    	String[] linkUrls = new String[links.size()];
    	String[] webHref = new String[links.size()];
    	int count = 0, count2=0;
    	for(WebElement wb: links) {
    		linkUrls[count] = wb.getAttribute("href").split("/")[3];
    		count++;
    	}
    	for(int x = 0; x < links.size(); x++) {
    		webHref[x] = "ul[class='top-menu notmobile'] a[href='/" + linkUrls[x]  + "']";
    	}
    	
    	for(String wh: webHref) {
    		By path = By.cssSelector(wh);
    		driver.findElement(path).click();
    		Thread.sleep(2000);
    		takeScreenShot(driver, "ss-01-menu_link");
    		logs.info("Each link has been clicked and navigated to "+linkUrls[count2]);
    		test.log(Status.PASS, "Navigated to "+linkUrls[count2]);
    		Thread.sleep(2000);
    		driver.navigate().back();
    		logs.info("It was redirected to home page");
    		Thread.sleep(2000);
    		count2++;
    		
    	}
 
        
    }
    
    @Then("^click on logout and close the browser$")
    public void click_on_logout_and_close_the_browser() throws Throwable {
        driver.findElement(By.className("ico-logout")).click();
        temp += "\n "+"User logged out from the browser";
		File F = new File("/Users/NU20463617/eclipse-workspace/QET_CoE_SeleniumL21/src/test/resources/resources/testdata/TC_04_test.txt");
		try {
			FileUtils.writeStringToFile(F, temp,Charset.defaultCharset());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		logs.info("CLosing the browser");
		extent.flush();
        driver.close();
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