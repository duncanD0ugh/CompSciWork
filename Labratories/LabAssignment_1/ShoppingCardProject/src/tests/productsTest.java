package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

import publicClasses.Products;

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

class productsTest {
	
	public static Products productsObject;
	public static String [] productNames = {"Lux Soap", "Fair n Lovely", "MTR"};
    public static Double [] productPrice = {40.00d, 60.00d, 30.00d};
    public static Integer [] stock = {10, 6, 10};
	
    @BeforeAll
	public static void setUpBeforeClass() throws Exception {}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	public void setUp() throws Exception 
	{
		productsObject = new Products();
	}

	@AfterEach
	public void tearDown() throws Exception {}
	
	@Test
	@SpiraTestCase(testCaseId=7685)
	public void initializeExistsTest() 
	{
        for(int i = 0; i < productsObject.products.size(); ++i)
        {
        	assertNotNull(productsObject.products.get(i));
        }
	}
	
	@Test
	@SpiraTestCase(testCaseId=7686)
	public void initializeNameTest() 
	{
        for(int i = 0; i < productsObject.products.size(); ++i)
        {
        	assertEquals(productNames[i], productsObject.products.get(i).getName());
        }
	}
	
	@Test
	@SpiraTestCase(testCaseId=7687)
	public void initializePriceTest() 
	{
        for(int i = 0; i < productsObject.products.size(); ++i)
        {
        	assertEquals(productPrice[i], productsObject.products.get(i).getPrice());
        }
	}
	
	@Test
	@SpiraTestCase(testCaseId=7688)
	public void initializeStockTest() 
	{
        for(int i = 0; i < productsObject.products.size(); ++i)
        {
        	assertEquals(stock[i], productsObject.products.get(i).getStock());
        }
	}
	
	@Test
	@SpiraTestCase(testCaseId=7690)
	public void initializePidTest() 
	{
        for(int i = 0; i < productsObject.products.size(); ++i)
        {
        	assertEquals(i+1, productsObject.products.get(i).getPid());
        }
	}
}
