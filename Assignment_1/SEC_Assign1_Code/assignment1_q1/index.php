<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Stored Cross Site Scripting Attack Test</title>
<link rel="stylesheet" 
href=https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
    .page-style{
        margin: 20px;        
    }
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
</style>

</head>
<body>
<div class="page-style"><h2STored Cross Site Scripting (XSS) Attack Test</h2></div>
<div class="page-style"><h4>Update User Information</h4></div>
<div class="page-style"><p>Enter credit Card Details:</p></div>
<div class="page-style">
    <form action="" method="get">
        <div class="form-group">
            <label for="email">Credit Card Number</label>
            <input type="text" class="form-control" name="creditCard" placeholder="Enter Credit Card Number">
        </div>
        <div class="form-group">
            <label for="description">CVN</label>
            <input type="text" class="form-control" name="CVN" placeholder="Enter CVN">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
		
    </form>
</div>
<div class="page-style">
<h3>
<?php
if(!empty($_GET['creditCard']) && !empty($_GET['CVN']))
{
	
	$servername = "localhost:3308";
	$username = "root";
	$password = "";
	$dbname = "ecommercedb";
	
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if (!$conn) {
	  die("Connection failed: " . mysqli_connect_error());
	}
	
	$name = $_GET["creditCard"];
	$desc = $_GET["CVN"];

	$sql = "INSERT INTO xsscreditcard (creditCard, CVN) VALUES ('$name', '$desc')";

	if (mysqli_query($conn, $sql)) {
	  echo "Card updated successfully";
	} else {
	  echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
	
	
	// Show All records
	$sql = "SELECT * FROM xsscreditcard";
	$result = mysqli_query($conn, $sql);
?>
	<table>
	<th>Credit Card ID</th><th>Credit Card Number</th><th>CVN</th>
    <?php
	if (mysqli_num_rows($result) > 0) {
	  // output data of each row
	  while($row = mysqli_fetch_assoc($result)) {
		echo "<tr><td><p>".$row['id']."</p></td><td><p>".$row['creditCard']."</p><td><p>".$row['CVN']."</p></td><tr>";
	  }
	} else {
	  echo "No Cards Listed Yet.";
	}

	mysqli_close($conn);

}
?>
</table>
</h3></div>
</body>
</html>
