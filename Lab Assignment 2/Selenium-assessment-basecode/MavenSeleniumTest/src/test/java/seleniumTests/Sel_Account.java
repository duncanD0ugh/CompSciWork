package seleniumTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_Account {

	private static ChromeDriver driver;
	private WebElement element;
	private static WebDriverWait wait;
	private static Select selector;
	private static String expectedResult;
	private static String actualResult;
	
	//Test account and login
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\drago\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.className("header_user_info")).click();
		
		driver.findElement(By.id("email_create")).sendKeys("zwv23171@bcaoo.com");
		
		driver.findElement(By.xpath("//*[@id=\'SubmitCreate\']")).click();
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("customer_firstname")).sendKeys("Frist");

		driver.findElement(By.id("customer_lastname")).sendKeys("Last");

		driver.findElement(By.id("passwd")).sendKeys("12345");
		
		selector = new Select(driver.findElement(By.id("days")));
		selector.selectByValue("1");
		
		selector = new Select(driver.findElement(By.id("months")));
		selector.selectByValue("1");
		
		selector = new Select(driver.findElement(By.id("years")));
		selector.selectByValue("2019");
		
		driver.findElement(By.id("address1")).sendKeys("Address");
		
		driver.findElement(By.id("city")).sendKeys("City");
		
		selector = new Select(driver.findElement(By.id("id_state")));
		selector.selectByValue("1");
		
		driver.findElement(By.id("postcode")).sendKeys("12345");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//*[@id=\'submitAccount\']")).click();
		//My account - My Store

	}

}
