package executionEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.utilities.ReadExcel;
import com.utilities.locators;

import actionkeywords.Keywords_Driven;
import constants.Constants;

public class Engine {

	Keywords_Driven keywordDriven;
	Method[] methods;
	

	public static By locator;



	public Engine() {


		keywordDriven= new Keywords_Driven();

		methods= keywordDriven.getClass().getMethods();

	}



	public void executeKeywords() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {


		for(int i=0; i<methods.length; i++) {

			if(methods[i].getName().equalsIgnoreCase(ReadExcel.keywordColumnValue)) {
				methods[i].invoke(keywordDriven);
				break;

			}

		}

	}




	public void findWebelementsToBeUsed() {


		switch (ReadExcel.locatorName) {
		
		case Constants.ID:

			locator= locators.getId(ReadExcel.locatorValue);

			break;

		case Constants.NAME:

			locator=locators.getName(ReadExcel.locatorValue);

			break;

		case Constants.CLASS_NAME:

			locator=locators.getClassName(ReadExcel.locatorValue);

			break;

		case Constants.XPATH:

			locator=locators.getXpath(ReadExcel.locatorValue);

			break;

		case Constants.LINKTEXT:

			locator=locators.getlinkText(ReadExcel.locatorValue);

			break;

		case Constants.PARTIAL_LINK_TEXT:

			locator=locators.getPartialLinkText(ReadExcel.locatorValue);

			break;

		case Constants.TAGNAME:

			locator=locators.getTagname(ReadExcel.locatorValue);

			break;


		default:
			break;
		}


	}



	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {


		ReadExcel readExcel=new ReadExcel();

		readExcel.getExcel(Constants.EXCEL_LOCATION);



		Engine engine = new Engine();


		for(int row=1; row<=ReadExcel.totalRows ;row++) {

			//keyword= readExcel.getLocatorKeywordData(row, locatorColumn,keywordColumn,dataColumn);
			
			readExcel.getLocatorKeywordData(row, Constants.LOCATOR_COLUMN,Constants.KEYWORD_COLUMN,
					Constants.DATA_COLUMN);

			
			
			engine.findWebelementsToBeUsed();
			
			engine.executeKeywords();






			/*
			 * if(keyword.equalsIgnoreCase("openBrowser")) {
			 * 
			 * Keywords_Driven.openBrowser();
			 * 
			 * } else if(keyword.equalsIgnoreCase("gotoURL")) {
			 * 
			 * Keywords_Driven.gotoURL();
			 * 
			 * }else if(keyword.equalsIgnoreCase("userName")) {
			 * 
			 * Keywords_Driven.userName();
			 * 
			 * } else if(keyword.equalsIgnoreCase("password")) {
			 * 
			 * Keywords_Driven.password();
			 * 
			 * } else if(keyword.equalsIgnoreCase("Login")) {
			 * 
			 * Keywords_Driven.Login();
			 * 
			 * } else if(keyword.equalsIgnoreCase("clickDirectory")) {
			 * 
			 * Keywords_Driven.clickDirectory();
			 * 
			 * } else if(keyword.equalsIgnoreCase("selectQALead")) {
			 * 
			 * Keywords_Driven.selectQALead();
			 * 
			 * } else if(keyword.equalsIgnoreCase("clickSearch")) {
			 * 
			 * Keywords_Driven.clickSearch(); }
			 * 
			 */

		}


	}

}
