		
		<?php 
		/* 
		* PayPal and database configuration 
		*/ 

		// PayPal configuration 
		define('PAYPAL_ID', 'duncanndo@gmail.com'); 
		define('PAYPAL_SANDBOX', TRUE); //TRUE or FALSE 

		define('PAYPAL_RETURN_URL', 'http://localhost/assignment2/assignment2_q1/success.php'); 
		define('PAYPAL_CANCEL_URL', 'http://localhost/assignment2/assignment2_q1/cancel.php'); 
		define('PAYPAL_NOTIFY_URL', 'http://localhost/assignment2/assignment2_q1/ipn.php'); 
		define('PAYPAL_CURRENCY', 'AUD'); 

		// Database configuration 
		define('DB_HOST', 'localhost:3308'); 
		define('DB_USERNAME', 'root'); 
		define('DB_PASSWORD', ''); 
		define('DB_NAME', 'ecommercedb'); 


		// Change not required 
		define('PAYPAL_URL', (PAYPAL_SANDBOX == true)?
		"https://www.sandbox.paypal.com/cgi-bin/webscr":
		"https://www.paypal.com/cgi-bin/webscr");

		?>
		
		
		
		