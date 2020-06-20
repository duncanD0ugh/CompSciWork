package seleniumTests;

import java.util.Iterator;
import java.util.Set;

//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_HomepageLinks 
{
	private static ChromeDriver driver;
//	private WebElement element;
	private static String expectedResult;
	private static String actualResult;
	static Set<String>ids;
	static Iterator<String> it;
	static String parent;
	static String child;
	static String child2;
	static String child3;
	static String child4;
	
	//Check all links on home page
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\drago\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();
		
		//Test "Contact us" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("contact-link")).click();
		expectedResult = "Contact us - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Sign in" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("header_user_info")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Search" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.name("submit_search")).click();
		expectedResult = "Search - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Cart" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a/b")).click();
		expectedResult = "Order - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Women" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[1]/a")).click();
		expectedResult = "Women - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Dresses" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a")).click();
		expectedResult = "Dresses - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "T-Shirts" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[3]/a")).click();
		expectedResult = "T-shirts - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 1" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[1]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Faded Short Sleeve T-shirts - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 2" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[2]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Blouse - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 3" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[3]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Dress - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 4" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[4]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Dress - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 5" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[5]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Summer Dress - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 6" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[6]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Summer Dress - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Product 7" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'homefeatured\']/li[7]/div/div[1]/div/a[1]/img")).click();
		expectedResult = "Printed Chiffon Dress - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Woman" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[2]/div/div/ul/li/a")).click();
		expectedResult = "Women - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Special" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[1]/a")).click();
		expectedResult = "Prices drop - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - New Products" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[2]/a")).click();
		expectedResult = "New products - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Best Sellers" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[3]/a")).click();
		expectedResult = "Best sales - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Our Stores" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[4]/a")).click();
		expectedResult = "Stores - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Contact Us" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[5]/a")).click();
		expectedResult = "Contact us - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Terms and Conditions" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[6]/a")).click();
		expectedResult = "Terms and conditions of use - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - About Us" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'block_various_links_footer\']/ul/li[7]/a")).click();
		expectedResult = "About us - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Sitemap" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[8]/a")).click();
		expectedResult = "Sitemap - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - My orders" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[1]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - My credit slips" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[2]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - My address" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[3]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - My personal info" link
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[5]/div/ul/li[4]/a")).click();
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Facebook" link
		driver.get("http://automationpractice.com/index.php");
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
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Twitter" link
		driver.get("http://automationpractice.com/index.php");
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
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - YouTube" link
		driver.get("http://automationpractice.com/index.php");
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
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
		
		//Test "Footer - Google+" link
		driver.get("http://automationpractice.com/index.php");
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
		System.out.println("\nExpected Result: " + expectedResult + 
				"\nActual Result: " + actualResult);
	}

}
