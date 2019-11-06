<?php
	session_start();

	include_once('tools.php');
	topModule('Receipt');

	$fp = fopen('products.txt','r'); 
	if (($headings = fgetcsv($fp, 0, "\t")) !== false) 
	{ 
		 while ( $cells = fgetcsv($fp, 0, "\t") ) 
		 { 
			 for ($x=1; $x<count($cells); $x++) 
			 {
				  $products[$cells[0]][$cells[1]][$headings[$x]]=$cells[$x]; 
			 }
		 } 
	 }

	$cartKeys = array_keys($_SESSION['cart']);
	$keys = array_keys($_SESSION);
	$guns = array_keys($_SESSION['cart']);

	$headers = "PurchaseDate	Name	Address	Mobile	Email	ID	OID	Quanity	UnitPrice	SubTotal";
	$newArray[0] = $headers;

	for($i = 0; $i < count($guns); $i++)
	{
		$id = $guns[$i];
		$rarity = array_keys($_SESSION['cart'][$id]);
		for($j = 0; $j < count($rarity); $j++)
		{
			$opt = $rarity[$j];

			$date = "DATE";
			$name = $_SESSION['order']['name'];
			$address = $_SESSION['order']['address'];
			$mobile = $_SESSION['order']['phoneNumber'];
			$email = $_SESSION['order']['email'];
			$productId = $id;
			$optionId = $opt;
			$quantity = $_SESSION['cart'][$id][$opt]['qty'];
			$unitPrice = $products[$id][$opt]['price'];
			$subTotal = "TOTAL";

			$newString = $date+	$name+	$address+	$mobile+	$email+	$productId+	$optionId+	$quantity+	$unitPrice+	$subTotal;
			echo $newString;
			$newArray[$j + 1] = $newString;
		}
	}

	file_put_contents("orders.txt", $newArray);
?>

	</main>
<?php
	endModule();
?>