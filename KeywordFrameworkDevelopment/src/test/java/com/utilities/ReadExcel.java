package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ReadExcel {

	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	public static String locatorColumnValue;
	public static String locatorName;
	public static String locatorValue;
	public static String keywordColumnValue;
	public static String dataColumnValue;
	public static int totalRows;

	public  void getExcel (String location) throws IOException {

		fileInputStream=new FileInputStream(location);

		workbook=new XSSFWorkbook(fileInputStream);

		sheet=workbook.getSheet(Constants.SHEET1);
		
		totalRows = sheet.getLastRowNum();

	}



	public void getLocatorKeywordData(int Row, int locatorColumn, int keywordColumn,  int dataColumn) {

		//		cell= sheet.getRow(Row).getCell(Column);
		//
		//		String cellvalue=cell.getStringCellValue();


		locatorColumnValue=	sheet.getRow(Row).getCell(locatorColumn).toString().trim();



		if(!locatorColumnValue.equalsIgnoreCase("NA")) {

			locatorName = locatorColumnValue.split("=")[0].toString().trim();
			locatorValue= locatorColumnValue.split("=")[1].toString().trim();

		} else {
			locatorName="NA";
			locatorValue="NA";
		}


		keywordColumnValue = sheet.getRow(Row).getCell(keywordColumn).toString().trim();

		dataColumnValue = sheet.getRow(Row).getCell(dataColumn).toString().trim();



          System.out.println(locatorName+ " : "+ locatorValue +" Keyword :"+keywordColumnValue+" Data :"+ dataColumnValue);



		//System.out.println(cellvalue);
		//return cellvalue;



	}



}
