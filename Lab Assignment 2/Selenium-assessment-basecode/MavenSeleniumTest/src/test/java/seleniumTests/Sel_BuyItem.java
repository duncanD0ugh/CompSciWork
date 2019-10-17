package seleniumTests;

//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_BuyItem 
{
	private static ChromeDriver driver;
//	private WebElement element;
//	private static WebDriverWait wait;
	private static Select selector;
//	private static String expectedResult;
//	private static String actualResult;
	
	//Search, add, item to cart
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\drago\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("Summer dress");
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		
		
		selector = new Select(driver.findElement(By.id("selectProductSort")));
		selector.selectByVisibleText("Price: Lowest first");
		
		driver.findElement(By.xpath(
				"//*[@id=\'center_column\']/ul/li[2]/div/div[1]/div/a[1]/img")).click();
		
		selector = new Select(driver.findElement(By.xpath("//*[@id=\'group_1\']")));
		selector.selectByValue("2");

		driver.findElement(By.name("Green")).click();

		driver.findElement(By.name("Submit")).click();
	}
}
