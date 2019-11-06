package jupiterTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
class Jup_Account 
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
	@SpiraTestCase(testCaseId=15049)
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
	@SpiraTestCase(testCaseId=15051)
	void testSignInPage()
	{
		driver.findElement(By.className("header_user_info")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(3)
	@Test
	@SpiraTestCase(testCaseId=15060)
	void testPageAccount()
	{
		//Must go get sample email from 10minuteemail.net
		driver.findElement(By.id("email_create")).sendKeys("GetSampleEmailFfrom@10minuteemail.net");
		driver.findElement(By.xpath("//*[@id=\'SubmitCreate\']")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(4)
	@Test
	@SpiraTestCase(testCaseId=15062)
	void testDetails()
	{
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
		
		expectedResult = "My account - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
}
