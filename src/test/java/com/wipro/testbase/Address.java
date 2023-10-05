package com.wipro.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Address {
	
	
	
	 WebDriver driver;
	
	public Address(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginBtn;
	
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement login;
	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement MyAccount;
	
	@FindBy(xpath="(//a[normalize-space()='Addresses'])[1]")
	WebElement address;
	
	@FindBy(xpath="//button[normalize-space()='Add new']")
	WebElement addnew;
	
	@FindBy(xpath="//input[@id='Address_FirstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='Address_LastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='Address_Email']")
	WebElement email;
	
	@FindBy(xpath="//select[@id='Address_CountryId']")
	WebElement country;
	
	
	@FindBy(id="Address_City")
	WebElement city;
	
	@FindBy(id="Address_Address1")
	WebElement address1;
	
	@FindBy(id="Address_ZipPostalCode")
	WebElement postalCode;
	
	
	@FindBy(id="Address_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement save;
	
	
	public void login_Button() {
		loginBtn.click();
	}
	
	public void usrName(String email) {
		username.sendKeys(email);
	}
	
	public void enter_Password(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void login() {
		login.click();
	}
	
	public void my_Acc() {
		MyAccount.click();
	}
	public void clickAddress() {
		address.click();
	}
	
	public void add_New() {
		addnew.click();
	}
	
	public void first_Name(String firstname) {
		firstName.sendKeys(firstname);
	}
	public void last_Name(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void Email(String mail) {
		email.sendKeys(mail);
	}
	
	public void add_Coutry(String couNtry) {
		Select s = new Select(country);
		s.selectByVisibleText(couNtry);
	}
	
	
	
	public void add_City(String citY) {
		city.sendKeys(citY);
	}
	
	public void add_Address1(String address) {
		address1.sendKeys(address);
	}
	
	public void postal_Code(String postal) {
		postalCode.sendKeys(postal);
	}
	
	public void phone_Number(String pNumber) {
		phoneNumber.sendKeys(pNumber);
	}
	
	public void click_Save() {
		save.click();
	}
	
	public void addAddresses(String password, String fname, String lname, String email, String country, String city, String address1, String postalcode, String phoneNumber) throws InterruptedException {
		Address ad = new Address(driver);
		ad.login_Button();
		ad.usrName(email);
		Thread.sleep(1000);
		ad.enter_Password(password);
		Thread.sleep(1000);
		ad.login();
		Thread.sleep(1000);
		ad.first_Name(fname);
		Thread.sleep(1000);
		ad.last_Name(lname);
		Thread.sleep(1000);
		ad.Email(email);
		Thread.sleep(1000);
		ad.add_Coutry(country);
		Thread.sleep(1000);
		
		ad.add_City(city);
		Thread.sleep(1000);
		ad.add_Address1(address1);
		Thread.sleep(1000);
		ad.postal_Code(postalcode);
		Thread.sleep(1000);
		ad.phone_Number(phoneNumber);
		Thread.sleep(1000);
		ad.click_Save();
		
	}
}
