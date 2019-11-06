package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

import publicClasses.Product;

@SpiraTestConfiguration(
		//following are REQUIRED 
		url = "https://rmit-university.spiraservice.net", 
		login = "s3718718", 
//		rssToken = "{XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX}", 
		password = "1;IO99y5x=KX+h",
		projectId = 498 
		//following are OPTIONAL 
//		,releaseId = 7, 
//		testSetId = 1 
		)

class productTests {
	
	public static Product productObject;
	public static Product otherProduct;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	public void setUp() throws Exception 
	{
		productObject = new Product();
		otherProduct = new Product();
	}

	@AfterEach
	public void tearDown() throws Exception {}
	
	@Test
	@SpiraTestCase(testCaseId=7675)
	public void equalsTest()
	{
		productObject.setName("a");
		productObject.setPid(1);
		otherProduct.setName("a");
		otherProduct.setPid(2);
		assertFalse(productObject.equals(otherProduct));
	}
	
	@Test
	@SpiraTestCase(testCaseId=7676)
	public void equalsTrueTest() 
	{
		Product copy = productObject;
		assertTrue(productObject.equals(copy));
	}
		
	@Test
	@SpiraTestCase(testCaseId=7677)
	public void equalsNullTest() 
	{
		assertFalse(productObject.equals(null));
	}	
	
	@Test
	@SpiraTestCase(testCaseId=7678)
	public void equalsGetClassTest() 
	{		
		assertTrue(productObject.equals(otherProduct));
	}	

	@Test
	@SpiraTestCase(testCaseId=7680)
	public void equalsNameTest() 
	{
		productObject.setName("Real Name");
		otherProduct.setName("Other Name");
		assertFalse(productObject.equals(otherProduct));
	}	
	
	@Test
	@SpiraTestCase(testCaseId=7682)
	public void equalsIdTest() 
	{
		productObject.setPid(1);
		otherProduct.setPid(2);
		assertFalse(productObject.equals(otherProduct));
	}	
	
	@Test
	@SpiraTestCase(testCaseId=7683)
	public void equalsPriceTest() 
	{
		productObject.setPrice(2.00);
		productObject.setPrice(1.00);
		otherProduct.setPrice(2.00);
		assertFalse(productObject.equals(otherProduct));
	}	
	
	@Test
	@SpiraTestCase(testCaseId=7684)
	public void equalsStockTest() 
	{
		productObject.setStock(1);;
		otherProduct.setStock(2);
		assertFalse(productObject.equals(otherProduct));
	}	
}
