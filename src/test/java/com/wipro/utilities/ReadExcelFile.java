package com.wipro.utilities;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelFile {

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//	
//		ReadExcelFile rd = new ReadExcelFile();
//		rd.getData("Sheet1");
//		
//	}
	
	@DataProvider(name="myTest")
	public String[][] getData(Method m) throws IOException 
	{
		String sheetName = m.getName();
		System.out.println(sheetName);
		File f = new File("C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources\\testdata\\Book 2.xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet_Name = wb.getSheet(sheetName);
		
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet_Name = wb.getSheet(m.getName());
//		int rows = sheet_Name.getPhysicalNumberOfRows();
//		int columns = sheet_Name.getRow(0).getPhysicalNumberOfCells();
		
		
		
		int rowCtn = sheet_Name.getLastRowNum();
		System.out.println(rowCtn);
		
		Row rowCells = sheet_Name.getRow(1);
		int colCtn = rowCells.getLastCellNum();
		System.out.println(colCtn);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[rowCtn][colCtn];
///		System.out.println(rowCells);
		//System.out.println(rows +" "+columns);
		for(int i=1;i<=rowCtn;i++) 
		{
			for(int j=0;j<colCtn;j++) 
			{
				
					testData[i-1][j]= format.formatCellValue(sheet_Name.getRow(i).getCell(j));
			}
		}
		
		return testData;
		
		
	}

}
