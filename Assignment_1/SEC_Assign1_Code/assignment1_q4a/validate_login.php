<?php
	session_start();
	require 'db_connection.php';
    $db = DB();
    
	require 'operation.php';
	$app = new Operation($db);
    $user = $app->UserDetails($_SESSION['user_id']);
    
	require_once __DIR__ . '/PHPGangsta/GoogleAuthenticator.php';
	$pga = new PHPGangsta_GoogleAuthenticator();
    $error_message = '';
    
    if (isset($_POST['btnValidate'])) 
    {
		$code = $_POST['code'];
        if ($code == "") 
        {
			$error_message ='Please enter authentication code to validated!';
		}
		else
		{
			if($pga->verifyCode($user->google_secret_code, $code, 2))
			{
				header("Location: profile.php");
			}
			else
			{
				$error_message = 'Invalid Authentication Code!';
			}
		}
	}
?>
		
<!doctype html>
<html lang="en">
    <body>
    <h2>Google's 2 Factor Authentication System</h1>
        <h2>Two Factor Authentication</h2>
            <form method="post" action="validate_login.php">
                <?php
                if ($error_message != "") 
                {
                    echo '<div class="alert alert-danger"><strong>Error: </strong> ' . $error_message . '</div>';
                }
                ?>
                <input type="text" name="code" placeholder="Enter Authentication Code" class="form-control"><br><br>
                <button type="submit" name="btnValidate" class="btn btn-primary">Validate</button>
            </form>
            Click here to <a href="index.php">Login</a> if you have already registered your account.
    </body>
</html>