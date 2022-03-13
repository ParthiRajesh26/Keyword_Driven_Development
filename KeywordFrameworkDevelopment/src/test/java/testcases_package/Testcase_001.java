package testcases_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_001 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C://chrome driver//chromedriver.exe");


		WebDriver driver=new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		WebElement userName = driver.findElement(By.id("txtUsername"));

		userName.sendKeys("Admin");


		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("admin123");


		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		loginButton.click();


	}

}
