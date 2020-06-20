package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

import publicClasses.Cart;
import publicClasses.Product;
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

class cartTests {
	public static Cart cartObject;
	public static Products productsObject;
	public static Product productObject;
	
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
		cartObject = new Cart();
		productsObject = new Products();
		productObject = new Product();
	}

	@AfterEach
	public void tearDown() throws Exception {}

	@Test
	@SpiraTestCase(testCaseId=7691)
	public void addItemTest() 
	{	
		cartObject.addToCart(productsObject.products.get(0));
		assertEquals(1, cartObject.cartItems.get(0).getPid());
	}
	
	@Test
	@SpiraTestCase(testCaseId=7694)
	public void addItemByIdTest() 
	{		
		cartObject.addProductToCartByPID(2);
		assertEquals(2, cartObject.cartItems.get(0).getPid());
	}
	
	@Test
	@SpiraTestCase(testCaseId=7692)
	public void getItemByIdTest() 
	{		
		cartObject.addToCart(productsObject.products.get(1));
		assertEquals(2, cartObject.getProductByProductID(2).getPid());
	}
	
	@Test
	@SpiraTestCase(testCaseId=7693)
	public void getItemByIdNullTest() 
	{	
		assertNull(cartObject.getProductByProductID(4));
	}
	
	@Test
	@SpiraTestCase(testCaseId=7695)
	public void removeItemByIdTest()
	{
		cartObject.addToCart(productsObject.products.get(0));
		cartObject.addToCart(productsObject.products.get(1));
		cartObject.addToCart(productsObject.products.get(2));	
		cartObject.removeProductByPID(2);
		assertEquals(3, cartObject.cartItems.get(1).getPid());
	}
}
