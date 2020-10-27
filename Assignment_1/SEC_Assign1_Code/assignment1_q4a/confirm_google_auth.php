<?php
    session_start();

    require 'db_connection.php';
    $db = DB();

    require 'operation.php';
    $app = new Operation($db);
    $user = $app->UserDetails($_SESSION['user_id']);

    require_once __DIR__ . '/PHPGangsta/GoogleAuthenticator.php';
    $pga = new PHPGangsta_GoogleAuthenticator();
    $qr_code =  $pga->getQRCodeGoogleUrl($user->email, $user->google_secret_code, 'Secure Electronic Commerce');

    $error_message = '';

    if (isset($_POST['btnValidate'])) 
    {

        $code = $_POST['code'];

        if ($code == "") 
        {
            $error_message = 'Please Scan above QR code to configure your application and enter genereated authentication code to validated!';
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
    <h1>Google's 2 Factor Authentication System</h1>
    <h2>Application Authentication</h2>
    <p>
        Please download and install Google authenticate app <br>
        on your phone, and scan following QR code to <br>
        configure your device.
    </p>
    <img src="<?php echo $qr_code; ?>"><br><br>
    <form method="post" action="confirm_google_auth.php">
        <?php
        if ($error_message != "") 
        {
            echo '<div class="alert alert-danger"><strong>Error: </strong> ' . $error_message . '</div>';
        }
        ?>
        <input type="text" name="code" placeholder="6 Digit Code" class="form-control"><br><br>
        <button type="submit" name="btnValidate" class="btn btn-primary">Validate</button><br><br>
    </form>
    Click here to <a href="index.php">Login</a> if you have already registered your account.
</body>
</html>