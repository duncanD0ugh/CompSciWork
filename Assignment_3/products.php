<?php
	session_start();
	include_once('tools.php');
	topModule('Guns');
	if (isset($_POST['cancel'])) 
	{
		unset($_SESSION['cart']);
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

	fclose($fp);
	$guns = array_keys($products);
	// preShow($guns);
	// preShow($products);

	if(isset($_GET['id']) && key_exists($_GET['id'], $products)) 
	{
		$id = $_GET['id'];
		$image = $products[$id]['BLUE']['img'];
		$title = $products[$id]['BLUE']['title'];
		$desc = $products[$id]['BLUE']['desc'];
		$price = $products[$id]['BLUE']['price'];
		
		productPage($image, $id, $title, $desc, $price);
	}
	else
	{
        for($i = 0; $i < count($guns); $i++)
	    {
			$image = $products[$guns[$i]]['BLUE']['img'];
			$id = $guns[$i];
			$title = $products[$guns[$i]]['BLUE']['title'];
			$desc = $products[$guns[$i]]['BLUE']['desc'];

			ProductsPage($image, $id, $title, $desc, $i);
	    }
	}

	endModule();
?>