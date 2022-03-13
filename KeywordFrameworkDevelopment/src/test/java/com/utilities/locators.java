package com.utilities;

import org.openqa.selenium.By;

public class locators {


	public static By getId(String locatorValue) {

		return By.id(locatorValue);

	}

	public static By getClassName(String locatorValue) {

		return By.className(locatorValue);

	}

	public static By getlinkText(String locatorValue) {

		return By.linkText(locatorValue);

	}

	public static By getTagname(String locatorValue) {

		return By.tagName(locatorValue);

	}

	public static By getPartialLinkText(String locatorValue) {

		return By.partialLinkText(locatorValue);

	}

	public static By getXpath(String locatorValue) {

		return By.xpath(locatorValue);

	}

	public static By getName(String locatorValue) {

		return By.name(locatorValue);

	}




}
