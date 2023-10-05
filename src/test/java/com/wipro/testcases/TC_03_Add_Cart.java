package com.wipro.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.wipro.testbase.Address1;
import com.wipro.testbase.Add_to_Cart;
import com.wipro.testbase.TestBase;
import com.wipro.utilities.ReadExcelFile;


public class TC_03_Add_Cart extends TestBase
{
	
	@Test(dataProviderClass=ReadExcelFile.class, dataProvider="myTest")
	public static void sheet2(String email, String password, String fname, String lname, String country, String city, String address1, String postalcode, String phonenumber) throws InterruptedException 
	{
		Address1 obj = new Address1();
		Add_to_Cart ac1 = new Add_to_Cart();
		obj.log_In(email, password); 
		ac1.add_to_Cart_1();

	}
	

}
