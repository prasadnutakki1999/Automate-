package com.wipro.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Read_Properties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader f = new FileReader("/Users/NU20463617/eclipse-workspace/QET_CoE_SeleniumL21/src/test/resources/resources/config_files/test.properties");
		
		Properties p = new Properties();
		p.load(f);
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("url"));
	}

}
