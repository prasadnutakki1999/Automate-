package com.wipro.testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Address1 extends TestBase{

	
	By login_Btn = By.xpath("//a[@class='ico-login']");
	By usrname = By.id("Email");
	By pwd = By.id("Password");
	By login = By.xpath("//button[normalize-space()='Log in']");
	By my_Account = By.xpath("//a[@class='ico-account']");
	By address = By.xpath("(//a[normalize-space()='Addresses'])[1]");
	By add_Addr = By.xpath("//button[normalize-space()='Add new']");
	By fname = By.xpath("//input[@id='Address_FirstName']");
	By lname = By.xpath("//input[@id='Address_LastName']");
	By mail = By.xpath("//input[@id='Address_Email']");
	By country = By.xpath("//select[@id='Address_CountryId']");
	By city = By.id("Address_City");
	By address1 = By.id("Address_Address1");
	By postal_Code = By.id("Address_ZipPostalCode");
	By phone_Number = By.id("Address_PhoneNumber");
	
	By save = By.xpath("//button[normalize-space()='Save']");
	By greenBox = By.cssSelector("span[class='close']");
	By log_out = By.className("ico-logout");
	
	
	//Errors
	By errMsg = By.cssSelector("div[class='message-error validation-summary-errors']");
	By emailErr = By.cssSelector("span[class='field-validation-error']");
	By loginIcon = By.cssSelector("a[class='ico-login']");
	
	
	
	public boolean loginErrors() 
	{
		return driver.findElement(errMsg).isDisplayed() || driver.findElement(emailErr).isDisplayed();
	}
	
	//
	
	public void login_Button()
	{
		driver.findElement(login_Btn).click();
	}
	
	public void username(String username) {
		driver.findElement(usrname).sendKeys(username);
	}
	public void password(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void login() {
		driver.findElement(login).click();
	}
	public void myAccount() {
		driver.findElement(my_Account).click();
	}
	public void click_Address() {
		driver.findElement(address).click();
	}
	public void add_Address(){
		driver.findElement(add_Addr).click();
	}
	
	public void first_Name(String f_name) {
		driver.findElement(fname).sendKeys(f_name);
	}
	public void last_Name(String l_name) {
		driver.findElement(lname).sendKeys(l_name);
	}
	public void e_Mail(String e_mail) {
		driver.findElement(mail).sendKeys(e_mail);
	}
	public void add_Country(String country_name) {
		driver.findElement(country).sendKeys(country_name);
	}
	public void add_City(String city_name) {
		driver.findElement(city).sendKeys(city_name);
	}
	public void add_address1(String address) {
		driver.findElement(address1).sendKeys(address);
	}
	public void add_postal(String postal_code) {
		driver.findElement(postal_Code).sendKeys(postal_code);
	}
	public void add_phone(String phone_number) {
		driver.findElement(phone_Number).sendKeys(phone_number);
	}
	public void save_btn() {
		driver.findElement(save).click();
	}
	public void grn_box() {
		driver.findElement(greenBox).click();
	}
	public void log_Out() {
		driver.findElement(log_out).click();
	}
	
	public void log_In(String email, String password) {
		Address1 addr = new Address1();
		addr.login_Button();
		logs.info("clicking on login button");
		addr.username(email);
		logs.info("user email entered "+email);
		addr.password(password);
		logs.info("user password entered "+password);
		addr.login();
		logs.info("user clicked login");
	}
	
	public void add_Addresses(String email,String fname, String lname, String country, String city, String address1, String postalcode, String phonenumber) {
		Address1 addr = new Address1();
		addr.myAccount();
		logs.info("clicking my_account button");
		addr.click_Address();
		logs.info("clicking address button");
		addr.add_Address();
		logs.info("clicking on add address button");
		addr.first_Name(fname);
		logs.info(" firstname  entered "+fname);
		addr.last_Name(lname);
		logs.info(" lastname  entered "+lname);
		addr.e_Mail(email);
		logs.info(" user Email entered "+email);
		addr.add_Country(country);
		logs.info(" country selected "+country);
		addr.add_City(city);
		logs.info("user city entered "+city);
		addr.add_address1(address1);
		logs.info("user address1 entered "+address1);
		addr.add_postal(postalcode);
		logs.info("user postal code entered "+postalcode);
		addr.add_phone(phonenumber);
		logs.info("user phone number entered "+phonenumber);
		addr.save_btn();
		logs.info("click on save button");
		addr.grn_box();
		logs.info("pop-up banner crossed");
	}
	public void logging_Out() {
		Address1 addr = new Address1();
		addr.log_Out();
		logs.info("user clicked on logout");
	}
//	public void LoginDoing(String email, String password, String fname, String lname, String country, String city, String address1, String postalcode, String phonenumber) 
//	{
//		Address1 addr = new Address1();
//		addr.login_Button();
//		addr.username(email);
//		addr.password(password);
//		addr.login();
//		addr.myAccount();
//		addr.click_Address();
//		addr.add_Address();
//		addr.first_Name(fname);
//		addr.last_Name(lname);
//		addr.e_Mail(email);
//		addr.add_Country(country);
//		addr.add_City(city);
//		addr.add_address1(address1);
//		addr.add_postal(postalcode);
//		addr.add_phone(phonenumber);
//		addr.save_btn();
//		addr.grn_box();
//		addr.log_Out();
//		screenShot();
//		tearDown();
//	}
}
