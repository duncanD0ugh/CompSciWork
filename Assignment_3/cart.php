<?php
	session_start();
	include_once('tools.php');
	topModule('Cart');
	if(isset($_POST['add'], $_POST['id'], $_POST['option'], $_POST['qty']))
	{
		if (!is_numeric($_SESSION['cart'][$_POST['id']][$_POST['option']]['qty']))
		{
			header("Location: products.php");
		}
		if(isset($_SESSION['cart'][$_POST['id']][$_POST['option']]))
		{
			$_SESSION['cart'][$_POST['id']][$_POST['option']]['qty'] += $_POST['qty'];
		}
		else
		{
			$_SESSION['cart'][$_POST['id']][$_POST['option']]['qty'] = $_POST['option'];
			$_SESSION['cart'][$_POST['id']][$_POST['option']]['qty'] = $_POST['qty'];
		}
	}
	else if(isset($_SESSION['cart']))
	{
		//do nothing if the cart is already set and they just want to go to their cart
	}
	else
	{
		header("Location: products.php");
	}

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

	// unset($_SESSION);
	$guns = array_keys($_SESSION['cart']);

	// echo "POST ARRAY";
	// preShow($_POST);
	// echo "GUNS ARRAY [Keys of the Session]";
	// preShow($guns);
	// echo "SESSION ARRAY";
	// preShow($_SESSION);


	for($i = 0; $i < count($guns); $i++)
	{
		$id = $guns[$i];
		$rarity = array_keys($_SESSION['cart'][$id]);
		for($j = 0; $j < count($rarity); $j++)
		{
			$image = $products[$id]['BLUE']['img'];
			$opt = $rarity[$j];
			$option = $_SESSION['cart'][$id][$opt];
			$qty = $_SESSION['cart'][$id][$opt]['qty'];
			cartDivs($id, $opt, $qty, $image);
		}
	}
?>

            <div>
				<form id=purchaseDetails method='post' onsubmit='return validateForm()' action='products.php'>
					<button><a href=checkout.php>Checkout</a></button><br>
					<button name='cancel' type='submit'>Empty Cart</button>
				</form>
            </div>
			
        </main>
<?php	
	endModule();
?>