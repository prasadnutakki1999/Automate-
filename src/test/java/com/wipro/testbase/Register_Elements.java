package com.wipro.testbase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Register_Elements extends TestBase{
	
//
//	WebDriver driver;
//
//	
//	public Register_Elements(WebDriver driver)
//	{
//
//        this.driver = driver;
//
//    }
	By  registerUser = By.className("ico-register");
	By fname = By.name("FirstName");
	By lname = By.name("LastName");
	By email_User = By.name("Email");
	By pass = By.name("Password");
	By cpass = By.name("ConfirmPassword");
	By clickReg = By.name("register-button");
	
	By emailAlreadyExist = By.cssSelector("div[class='message-error validation-summary-errors']");
	

	
	public void RegisterMethod()
	{
		driver.findElement(registerUser).click();
		
	}
	public void FName(String firstname)
	{
		
		driver.findElement(fname).sendKeys(firstname);
	}
	
	public void Lname(String lastname)
	{
		driver.findElement(lname).sendKeys(lastname);;
	}
	public void Email(String email)
	{
		driver.findElement(email_User).sendKeys(email);
	}
	public void PassWord(String password)
	{
		driver.findElement(pass).sendKeys(password);
	}
	public void ConfirmPassword(String confirm_password)
	{
		driver.findElement(cpass).sendKeys(confirm_password);
	}
	public void ClickRegister()
	{
		driver.findElement(clickReg).click();
		
		String s ="User got registered";
		File F = new File("C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources\\testdata\\TC_01_test.txt");
		try {
			FileUtils.writeStringToFile(F, s,Charset.defaultCharset());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean usermailAlreadyExistError() {
		return driver.findElement(emailAlreadyExist).isDisplayed();
	}
	
	
	
	
	public void reg_Elements(String firstname, String lastname, String email, String password, String confirm_password) throws IOException, InterruptedException {
		Register_Elements obj = new Register_Elements();
		//ExtentTest test = report.createTest("Register");
		obj.RegisterMethod();
		logs.info("Register button clicked");
		//test.log(Status.PASS, "Register Clicked");
		obj.FName(firstname);
		logs.info(" firstname  entered "+firstname);
		//test.log(Status.PASS, "FirstName Entered");
		obj.Lname(lastname);
		logs.info("Lastname entered "+lastname);
		//test.log(Status.PASS, "LastName Entered");
		obj.Email(email);
		logs.info("Email entered "+email);
		//test.log(Status.PASS, "Email Entered");
		obj.PassWord(password);
		logs.info("password entered "+password);
		//test.log(Status.PASS, "Password Entered");
		obj.ConfirmPassword(confirm_password);
		logs.info("COnfirm_Password entered "+confirm_password);
		//test.log(Status.PASS, "Confirm-Password Entered");
		obj.ClickRegister();
		logs.info("clicking on register");
		Thread.sleep(5000);
		
		
		
	}
	
}
