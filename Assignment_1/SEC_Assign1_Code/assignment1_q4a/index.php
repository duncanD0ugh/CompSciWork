<?php

// Start Session
session_start();

// Load PHP files for Database connection
require 'db_connection.php';
$db = DB();

// Load the operation implementations ( i.e., Operation class )
require 'operation.php';
$app = new Operation($db);

$login_error_message = '';

// check Login request
if (!empty($_POST['btnLogin'])) {

    $username = trim($_POST['username']);
    $password = trim($_POST['password']);

    if ($username == "") {
        $login_error_message = 'Username field is required!';
    } else if ($password == "") {
        $login_error_message = 'Password field is required!';
    } else {
        $user_id = $app->Login($username, $password); // check user login
        if($user_id > 0)
        {
            $_SESSION['user_id'] = $user_id; // Set Session
            header("Location: validate_login.php"); // Redirect user to validate auth code
        }
        else
        {
            $login_error_message = 'Invalid login details!';
        }
    }
}
?>
<!doctype html>
<html lang="en">
<body>
	<h1> Google's 2 Factor Authentication System </h1>
	<h2>Login</h2>
		<?php
		if ($login_error_message != "") {
			echo '<div class="alert alert-danger"><strong>Error: </strong> ' . $login_error_message . '</div>';
		}
		?>
		<form action="index.php" method="post">
			<input type="text" name="username" placeholder ="Enter your username" class="form-control"/><br><br>
			<input type="password" name="password" placeholder ="Enter your password" class="form-control"/><br><br>
			<input type="submit" name="btnLogin" class="btn btn-primary" value="Login"/>
		</form>
		<div class="form-group">
			Not Registered Yet? <a href="registration.php">Register Here</a>
</body>
</html>