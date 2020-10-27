<?php
	session_start();

	require 'db_connection.php';
	$db = DB();

	require 'operation.php';
	$app = new Operation($db);

	require_once __DIR__ . '/PHPGangsta/GoogleAuthenticator.php';
	$pga = new PHPGangsta_GoogleAuthenticator();
	$secret = $pga->createSecret();

	$register_error_message = '';

	if (!empty($_POST['btnRegister'])) 
	{
		if ($_POST['name'] == "") 
		{
			$register_error_message = 'Name field is required!';
		} 
		else if ($_POST['email'] == "") 
		{
			$register_error_message = 'Email field is required!';
		} 
		else if ($_POST['username'] == "") 
		{
			$register_error_message = 'Username field is required!';
		} 
		else if ($_POST['password'] == "") 
		{
			$register_error_message = 'Password field is required!';
		} 
		else if (!filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) 
		{
			$register_error_message = 'Invalid email address!';
		}
		else if ($app->isEmail($_POST['email'])) 
		{
			$register_error_message = 'Email is already in use!';
		} 
		else if ($app->isUsername($_POST['username'])) 
		{
			$register_error_message = 'Username is already in use!';
		} 
		else 
		{
			$user_id = $app->Register($_POST['name'], $_POST['email'], $_POST['username'], $_POST['password'], $secret);
			$_SESSION['user_id'] = $user_id;
			header("Location: confirm_google_auth.php");
		}
	}
?>
<!doctype html>
<html lang="en">
<body>
	<h1>Google's 2 Factor Authentication system</h1>
	<h2>Register</h2>
	<?php
		if ($register_error_message != "") 
		{
			echo '<div class="alert alert-danger"><strong>Error: </strong> ' . 
			$register_error_message . '</div>';
		}
	?>
	<form action="registration.php" method="post">
		<input type="text" name="name" placeholder="Please enter your name" class="form-control"/><br><br>
		<input type="email" name="email" placeholder="Please enter your email" class="form-control"/><br><br>
		<input type="text" name="username" placeholder="Please enter your username" class="form-control"/><br><br>
		<input type="password" name="password" placeholder="Please enter your password" class="form-control"/><br><br>
		<input type="submit" name="btnRegister" class="btn btn-primary" value="Register"/>
	</form>
	<div class="form-group">
	Click here to <a href="index.php">Login</a> 
	if you have already registred your account.
</body>
</html>