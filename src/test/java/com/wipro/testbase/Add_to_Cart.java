package com.wipro.testbase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_to_Cart extends TestBase 
{
	String info = "";
	String price_Info=""; 
	String temp ="";
	public Add_to_Cart()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
	WebElement Computers_Menu;
	
	@FindBy(xpath="//li[@class='inactive']//a[normalize-space()='Desktops']")
	WebElement Desktop_link;
	
	@FindBy(xpath="//a[normalize-space()='Digital Storm VANQUISH 3 Custom Performance PC']")
	WebElement desktop_Name;
	
	@FindBy(xpath="(//span[normalize-space()='$1,259.00'])[1]")
	WebElement desktop_Price;
	
	@FindBy(xpath="//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]")
	WebElement Add_cart;
	
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement ShoppingCart;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement Terms_CheckBox;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement CheckOut;
	
	
	@FindBy(css="div[id$='billing-buttons-container'] button[name='save']")
	WebElement Check_Continue;
	
	@FindBy(xpath="(//button[@class='button-1 shipping-method-next-step-button'])[1]")
	WebElement Continue1;
	
	@FindBy(xpath="(//button[@class='button-1 payment-method-next-step-button'])[1]")
	WebElement Continue2;
	
	@FindBy(xpath="(//button[@class='button-1 payment-info-next-step-button'])[1]")
	WebElement Continue3;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement Confirm;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement Continue4;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logout_clicked;
	
	public void click_On_Computer() {
		Computers_Menu.click();
	}
	
	public void click_On_Desktop() {
		Desktop_link.click();
	}
	
	public void desktop_Name_Info() throws InterruptedException {
		Thread.sleep(1000);
		 info += desktop_Name.getText();
		 System.out.println(info);
		
//		File F = new File("/Users/NU20463617/eclipse-workspace/QET_CoE_SeleniumL21/src/test/resources/resources/testdata/TC_03_test.txt");
//		try {
//			FileUtils.writeStringToFile(F, info,Charset.defaultCharset());
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public void desktop_Price_Info() {
		price_Info += desktop_Price.getText();
		temp=info+price_Info;
		
		File F = new File("C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources\\testdata\\TC_03_test.txt");
		try {
			FileUtils.writeStringToFile(F, temp,Charset.defaultCharset());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add_To_Cart() {
		Add_cart.click();
	}
	
	public void click_On_ShoppingCart() {
		ShoppingCart.click();
	}
	
	public void click_On_Terms() {
		Terms_CheckBox.click();
	}
	
	public void click_checkout() {
		CheckOut.click();
	}
	
	public void click_check_continue() {
		Check_Continue.click();
	}
	
	public void continue_1() {
		Continue1.click();
	}
	
	public void continue_2() {
		Continue2.click();
	}
	
	public void continue_3() {
		Continue3.click();
	}
	
	public void confirm_Click() {
		Confirm.click();
	}
	
	public void continue_4() {
		Continue4.click();
	}
	
	public void click_On_Logout() {
		logout_clicked.click();
	}
	
	public void add_to_Cart_1() throws InterruptedException {
		Add_to_Cart ac = new Add_to_Cart();
		ac.click_On_Computer();
		logs.info("user clicking on computer");
		Thread.sleep(2000);
		ac.click_On_Desktop();
		logs.info("user clicking on desktops");
		Thread.sleep(2000);
		ac.add_To_Cart();
		logs.info("user clicking on add_to_cart");
		Thread.sleep(6000);
		ac.click_On_ShoppingCart();
		logs.info("clicking on shopping cart at the top");
		Thread.sleep(2000);
		ac.click_On_Terms();
		logs.info("checking terms and conditions");
		Thread.sleep(1000);
		ac.click_checkout();
		logs.info("clicking on checkout");
		Thread.sleep(1000);
		ac.click_check_continue();
		logs.info("clicking on billing_address_continue");
		Thread.sleep(1000);
		ac.continue_1();
		logs.info("clicking on shipping_method_continue");
		Thread.sleep(1000);
		ac.continue_2();
		logs.info("clicking on payment_method_continue");
		Thread.sleep(1000);
		ac.continue_3();
		logs.info("clicking on payment_continue");
		Thread.sleep(1000);
		ac.confirm_Click();
		logs.info("clicking on confirming order");
		Thread.sleep(1000);
		ac.continue_4();
		logs.info("clicking on thanking_you_continue");
		Thread.sleep(1000);
		ac.click_On_Logout();
		logs.info("clicking on logout");
		
	}

}
