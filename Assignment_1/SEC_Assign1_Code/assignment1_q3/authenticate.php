<?php
    session_start();

    $email;
    $pass;
    if(isset($_POST['email']))
    {
    $email=$_POST['email'];
    }
    if(isset($_POST['pass']))
    {
    $pass=$_POST['pass'];
    }

    function generateRandomString($length = 6)
    {
        $characters = '0123456789';
        $charactersLength = strlen($characters);
        $randomString = '';
        for ($i = 0; $i < $length; $i++) 
        {
            $randomString .= $characters[rand(0, $charactersLength - 1)];
        }
        return $randomString;
    }
    $code = generateRandomString();
    $_SESSION['verifyCode'] = $code;

    $msg = "This is your 6-digit verification code: $code";
    $headers = "From: duncanndo@gmail.com" . "\r\n" .
                "MIME-Version: 1.0" . "\r\n" .
                "Content-Type: text/html; charset=utf-8";
    mail($email,"Email 2FA",$msg, $headers);
?>

<html>
  <head>
    <title>SEC Assignment 1 :: Email 2FA</title>
  </head>
  <body>
    <h1>Email 2FA</h1>
    <form id="comment_form" action="form.php" method="post">
      <input type="text" name="code" placeholder="Type your 6-digit code" size="40"><br><br>
      <input type="submit" name="submit" value="Authenticate">
    </form>
  </body>
</html>