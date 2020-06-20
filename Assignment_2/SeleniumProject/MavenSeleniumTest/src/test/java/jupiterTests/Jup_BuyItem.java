/**
 * 
 */
package jupiterTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.Order;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

/**
 * @author drago
 *
 */
@SpiraTestConfiguration(
		url = "https://rmit-university.spiraservice.net",
		login = "s3718718", 
		rssToken = "{A41328C5-FB6B-4647-8873-6C4664CB031E}", 
		projectId = 498
)
@TestMethodOrder(OrderAnnotation.class)
class Jup_BuyItem 
{
	private static ChromeDriver driver;
	private String expectedResult;
	private String actualResult;
	private static Select selector;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\drago\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		driver.close();
	}

	@Order(1)
	@Test
	@SpiraTestCase(testCaseId=15229)
	void testWebsite() 
	{
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(2)
	@Test
	@SpiraTestCase(testCaseId=15232)
	void testSearchForItem() 
	{
		driver.findElement(By.id("search_query_top")).sendKeys("Summer dress");
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "http://automationpractice.com/index.php?controller=search&orderby="
				+ "position&orderway=desc&search_query=Summer+dress&submit_search=";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(3)
	@Test
	@SpiraTestCase(testCaseId=15233)
	void testSortByPrice() 
	{
		selector = new Select(driver.findElement(By.id("selectProductSort")));
		selector.selectByVisibleText("Price: Lowest first");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "http://automationpractice.com/index.php?controller=search&search_query="
				+ "Summer+dress&submit_search=&orderby=price&orderway=asc";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(4)
	@Test
	@SpiraTestCase(testCaseId=15234)
	void testSelectItemFromSearch() 
	{
		driver.findElement(By.xpath(
				"//*[@id=\'center_column\']/ul/li[2]/div/div[1]/div/a[1]/img")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "http://automationpractice.com/index.php?id_product=7&controller="
				+ "product&search_query=Summer+dress&results=4";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(5)
	@Test
	@SpiraTestCase(testCaseId=15236)
	void testItemSizeOption() 
	{
		selector = new Select(driver.findElement(By.xpath("//*[@id=\'group_1\']")));
		selector.selectByValue("2");
		expectedResult = "http://automationpractice.com/index.php?id_product=7&controller="
				+ "product&search_query=Summer+dress&results=4#/color-yellow/size-m";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(6)
	@Test
	@SpiraTestCase(testCaseId=15237)
	void testItemColourOption()
	{
		driver.findElement(By.name("Green")).click();
		expectedResult = "http://automationpractice.com/index.php?id_product=7&controller="
				+ "product&search_query=Summer+dress&results=4#/size-m/color-green";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Order(7)
	@Test
	@SpiraTestCase(testCaseId=15287)
	void testAddToCart()
	{
		driver.findElement(By.name("Submit")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "http://automationpractice.com/index.php?id_product=7&controller="
				+ "product&search_query=Summer+dress&results=4#/size-m/color-green";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}

}
