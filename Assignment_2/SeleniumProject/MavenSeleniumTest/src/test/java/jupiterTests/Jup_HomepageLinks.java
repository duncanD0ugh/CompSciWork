package jupiterTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;


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
class Jup_HomepageLinks 
{
	private static ChromeDriver driver;
	private String expectedResult;
	private String actualResult;
	static Set<String>ids;
	static Iterator<String> it;
	static String parent;
	static String child;
	static String child2;
	static String child3;
	static String child4;

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
		ids = driver.getWindowHandles();
		it = ids.iterator();
		parent = it.next();
		child = it.next();
		child2 = it.next();
		child3 = it.next();
		child4 = it.next();
		driver.switchTo().window(child4);
		driver.close();
		driver.switchTo().window(child3);
		driver.close();
		driver.switchTo().window(child2);
		driver.close();
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(parent);
		driver.close();
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		driver.get("http://automationpractice.com/index.php");	
	}

	@Order(1)
	@Test
	@SpiraTestCase(testCaseId=15331)
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
	@SpiraTestCase(testCaseId=15332)
	void testContactUsLink() 
	{
		driver.findElement(By.id("contact-link")).click();
		expectedResult = "Contact us - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(3)
	@Test
	@SpiraTestCase(testCaseId=15333)
	void testSignInLink()
	{
		driver.findElement(By.className("header_user_info")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(4)
	@Test
	@SpiraTestCase(testCaseId=15334)
	void testSearchLink()
	{
		driver.findElement(By.name("submit_search")).click();
		expectedResult = "Search - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(5)
	@Test
	@SpiraTestCase(testCaseId=15335)
	void testCartLink()
	{
		driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a/b")).click();
		expectedResult = "Order - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(6)
	@Test
	@SpiraTestCase(testCaseId=15336)
	void testWomenLink()
	{
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[1]/a")).click();
		expectedResult = "Women - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(7)
	@Test
	@SpiraTestCase(testCaseId=15337)
	void testDressesLink()
	{
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a")).click();
		expectedResult = "Dresses - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(8)
	@Test
	@SpiraTestCase(testCaseId=15338)
	void testTShirtLink()
	{
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[3]/a")).click();
		expectedResult = "T-shirts - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(9)
	@Test
	@SpiraTestCase(testCaseId=15340)
	void testProduct1()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[1]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Faded Short Sleeve T-shirts - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}

	@Order(10)
	@Test
	@SpiraTestCase(testCaseId=15341)
	void testProduct2()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[2]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Blouse - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(11)
	@Test
	@SpiraTestCase(testCaseId=15342)
	void testProduct3()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[3]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(12)
	@Test
	@SpiraTestCase(testCaseId=15343)
	void testProduct4()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[4]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(13)
	@Test
	@SpiraTestCase(testCaseId=15344)
	void testProduct5()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[5]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Summer Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(14)
	@Test
	@SpiraTestCase(testCaseId=15345)
	void testProduct6()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[6]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Summer Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(15)
	@Test
	@SpiraTestCase(testCaseId=15346)
	void testProduct7()
	{
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[7]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Chiffon Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(16)
	@Test
	@SpiraTestCase(testCaseId=15347)
	void testFooterWoman()
	{
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[2]/div/div/ul/li/a")).click();
		expectedResult = "Women - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(17)
	@Test
	@SpiraTestCase(testCaseId=15348)
	void testFooterSpecial()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[1]/a")).click();
		expectedResult = "Prices drop - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(18)
	@Test
	@SpiraTestCase(testCaseId=15349)
	void testFooterNewProducts()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[2]/a")).click();
		expectedResult = "New products - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(19)
	@Test
	@SpiraTestCase(testCaseId=15350)
	void testFooterBestSellers()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[3]/a")).click();
		expectedResult = "Best sales - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(20)
	@Test
	@SpiraTestCase(testCaseId=15351)
	void testFooterStores()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[4]/a")).click();
		expectedResult = "Stores - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(21)
	@Test
	@SpiraTestCase(testCaseId=15352)
	void testFooterContactUs()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[5]/a")).click();
		expectedResult = "Contact us - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(22)
	@Test
	@SpiraTestCase(testCaseId=15353)
	void testFooterTnC()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[6]/a")).click();
		expectedResult = "Terms and conditions of use - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(23)
	@Test
	@SpiraTestCase(testCaseId=15354)
	void testFooterAboutUs()
	{
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[7]/a")).click();
		expectedResult = "About us - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(24)
	@Test
	@SpiraTestCase(testCaseId=15355)
	void testFooterSiteMap()
	{
		driver.findElement(By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[8]/a")).click();
		expectedResult = "Sitemap - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(25)
	@Test
	@SpiraTestCase(testCaseId=15356)
	void testFooterOrders()
	{
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[1]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
	
	@Order(26)
	@Test
	@SpiraTestCase(testCaseId=15357)
	void testFooterCreditSlips()
	{
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[2]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(27)
	@Test
	@SpiraTestCase(testCaseId=15358)
	void testFooterAddress()
	{
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[3]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(28)
	@Test
	@SpiraTestCase(testCaseId=15359)
	void testFooterPersonalInfo()
	{
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[4]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
	
	@Order(29)
	@Test
	@SpiraTestCase(testCaseId=15360)
	void testFooterFacebook()
	{
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[1]/a")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ids = driver.getWindowHandles();
		it = ids.iterator();
		parent = it.next();
		child = it.next();
		driver.switchTo().window(child);
		expectedResult = "Selenium Framework public group | Facebook";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(30)
	@Test
	@SpiraTestCase(testCaseId=15361)
	void testFooterTwitter()
	{
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[2]/a")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ids = driver.getWindowHandles();
		it = ids.iterator();
		parent = it.next();
		child = it.next();
		child2 = it.next();
		driver.switchTo().window(child2);
		expectedResult = "Selenium Framework (@seleniumfrmwrk) | Twitter";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(31)
	@Test
	@SpiraTestCase(testCaseId=15362)
	void testFooterYouTube()
	{
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[3]/a")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ids = driver.getWindowHandles();
		it = ids.iterator();
		parent = it.next();
		child = it.next();
		child2 = it.next();
		child3 = it.next();
		driver.switchTo().window(child3);
		expectedResult = "Selenium Framework - YouTube";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Order(32)
	@Test
	@SpiraTestCase(testCaseId=15363)
	void testFooterGooglePlus()
	{
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[4]/a")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ids = driver.getWindowHandles();
		it = ids.iterator();
		parent = it.next();
		child = it.next();
		child2 = it.next();
		child3 = it.next();
		child4 = it.next();
		driver.switchTo().window(child4);
		expectedResult = "Sign in – Google accounts";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
}
