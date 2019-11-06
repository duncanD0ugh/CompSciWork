<?php
	session_start();
	include_once('tools.php');
	topModule('Checkout');

	if (isset($_POST['cancel'])) 
	{
		unset($_SESSION);
	}
	// unset($_SESSION);

    $name = $email = $address = $phoneNumber = $creditCard = $expiryDate = "";
	$nameError = $emailError = $addressError = $phoneError = $cardError = $expiryError = "";
	$errorsFound = false;
	$expiryDate2 = $advancedDate = "";


	if (!empty($_POST))
    {	
		if (!isset($_POST["name"]))
		{
			$nameError = '<span style="color:red">Must have a name!</span>';
			$errorsFound = true;
		}
		else
		{
			$name = inputFilter($_POST["name"]);
		
        	if (!preg_match('/^([A-Za-z .,\'-])+$/', $name))
    	    {
				$nameError = '<span style="color:red">Invalid Name!</span>';
				$errorsFound = true;
			}
		}

		if (!isset($_POST["email"]))
		{
			$emailError = '<span style="color:red">Must have an email!</span>';
			$errorsFound = true;
		}
		else
		{
			$email = inputFilter($_POST["email"]);
        	if (!filter_var($email, FILTER_VALIDATE_EMAIL))
    	    {
	            $emailError = '<span style="color:red">Invalid Email!</span>';
				$errorsFound = true;
			}
		}

		if (!isset($_POST["address"]))
		{
			$addressError = '<span style="color:red">Must have an address!</span>';
			$errorsFound = true;
		}
		else
		{
			$address = $_POST["address"];
			$address = trim($address);
        	$address= stripslashes($address);
       		$address = htmlspecialchars($address, ENT_COMPAT);
    	    if (!preg_match('/^([0-9A-Za-z .,\'\-\/\n])+$/', $address))
	        {
				$addressError = '<span style="color:red">Invalid Address!</span>';
				$errorsFound = true;
			}
		}

		if (!isset($_POST["phoneNum"]))
		{
			$phoneError = '<span style="color:red">Must have an phone Number!</span>';
			$errorsFound = true;
		}
		else
		{
			$phoneNumber = inputFilter($_POST["phoneNum"]);
			if (!preg_match('/^((\+614)|(\(04\))|(04)){1}(\s)?([\d]\s?){8}$/', $phoneNumber))
			{
				$phoneError = '<span style="color:red">Invalid Phone Number!</span>';
				$errorsFound = true;
			}
		}

		if (!isset($_POST["creditCard"]))
		{
			$cardError = '<span style="color:red">Must have a payment method!</span>';
			$errorsFound = true;
		}
		else
		{
			$creditCard = inputFilter($_POST["creditCard"]);
			if (!preg_match('/^(?:[\d]\s?){12,19}$/', $creditCard))
	        {
				$cardError = '<span style="color:red">Invalid Card Number!</span>';
				$errorsFound = true;
			}
		}

		if (!isset($_POST["expiryDate"]))
		{
			$expiryError = '<span style="color:red">Must have a card expiry date!</span>';
			$errorsFound = true;
		}
		else
		{
			$expiryDate = $_POST["expiryDate"];
			$expiryDate2 = strtotime($expiryDate);
			$advancedDate = strtotime("+28 days");

			if ($expiryDate2 < $advancedDate) 
			{
				$cardError = '<span style="color:red">Card can not be expiring within 28 days!</span>';
				$errorsFound = true;
			}
		}

		if (!$errorsFound)
		{
			$_SESSION['order']["name"] = $name;
			$_SESSION['order']["email"] = $email;
			$_SESSION['order']["address"] = $address;
			$_SESSION['order']["phoneNumber"] = $phoneNumber; 
			$_SESSION['order']["creditCard"] = $creditCard;
			$_SESSION['order']["expiryDate"] = $expiryDate;
			header('Location: receipt.php');
		}
    }

    function inputFilter($input)
    {
        $input = trim($input);
        $input = stripslashes($input);
        $input = htmlspecialchars($input);
        return $input;
	}
	

?>
		<div class=container>
			<div class="container loginForm">
				<form method='post' action="checkout.php" id="checkoutForm">
					<p class='formRow'>
						<label for="name">Name:</label>
						<input class='formInput' type='text' id="name" name='name' placeholder='Name' value='<?php echo $name?>' required>
						<?php echo $nameError?>
						<br>
						<br>
					</p>
					<p class='formRow'>
						<label for="email">Email:</label>
						<input class='formInput' type='email' id="email" name='email' placeholder='example@email.com' value='<?php echo 
						$email?>'required><?php echo $emailError?>
						<br>
						<br>
					</p>
					<p class='formRow'>
						<label for="address">Address:</label>
						<!-- <textarea form="checkoutForm" class='formInput' rows="5" cols = "60" id="address" name="address" value='
						placeholder='1 Example Drive &#10;Fake Suburb &#10;VIC'required></textarea> -->
						<input class='formInput' type="text area" rows="5" cols = "60" id="address" name="address" required><?php echo $addressError?>
						<br>
						<br>
					</p>
					<p class='formRow'>
						<label for="phoneNum">Phone:</label>
						<input class='formInput' type="text" id="phoneNum" name="phoneNum" value='<?php echo $phoneNumber?>' required><?php 
						echo $phoneError?>
						<br>
						<br>
					</p>
					<p class='formRow'>
						<label for="creditCard">Credit Card:</label>
						<input class='formInput' type="text" id="creditCard" name="creditCard" oninput="setLogoVisibility()" value='<?php echo 
						$creditCard?>'
						required><?php echo $cardError?>
						<img class='visaImg' id='visaImg' src='../../media/VISA.png'>
					</p>
					<p class='formRow'>
						<label for="expiryDate">Expiry Date:</label>
						<input class='formInput' type="date" id="expiryDate" name="expiryDate" value='<?php echo $expiryDate?>' required><?php 
						echo $expiryError?>
						<br>
						<br>
					</p>
					<p class='formRow'></p>
					<button name='purchase' value='purchase' type='submit' class='formInput'>Purchase</button>
					<button name='cancel'><a href=checkout.php>Reset Form</a></button><br>
					<!-- <input class='formInput' type="submit" value="Purchase"> -->
				</form>
			</div>
		</div>

	<script>
	function setLogoVisibility() 
	{
		var term = document.getElementById("creditCard").value;
		if (term == null)
		{
			return;
		}
		var visaRegex = /^4(?:[\d]\s?){12,15}$/;
		if (visaRegex.test(term)) 
		{
			console.log("if statement met");
			document.getElementById("visaImg").style.visibility = "visible";

			;
		}
		else if (document.getElementById("visaImg").src != null)
		{
			console.log("else if statement met");
			document.getElementById("visaImg").style.visibility = "hidden";
		}
	}
	</script>

	</main>
<?php
	endModule();
?>