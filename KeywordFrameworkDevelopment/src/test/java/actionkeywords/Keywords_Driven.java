package actionkeywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.utilities.ReadExcel;

import constants.Constants;
import executionEngine.Engine;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords_Driven {

	static WebDriver driver;


	public static void openBrowser() {

		switch (ReadExcel.dataColumnValue) {
		case Constants.CHROME:
            
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
			
		case Constants.FIRE_FOX:

			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();

			break;

		case Constants.SAFARI:
			
			WebDriverManager.safaridriver().setup();
			
			driver=new SafariDriver();

			break;
			
		default:
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
		}


	}


	public static void gotoURL() {

		driver.get(ReadExcel.dataColumnValue);

	}


	public static void userName() {

		WebElement userName = driver.findElement(Engine.locator);
		userName.sendKeys(ReadExcel.dataColumnValue);

	}


	public static void password() {

		WebElement password=driver.findElement(Engine.locator);
		password.sendKeys(ReadExcel.dataColumnValue);

	}

	public static void click() {

		WebElement loginButton = driver.findElement(Engine.locator);
		loginButton.click();

	}



	public static void selectQALead() {

		WebElement dropDown= driver.findElement(Engine.locator);
		Select select=new Select(dropDown);
		select.selectByVisibleText("QA Lead");

	}



}
