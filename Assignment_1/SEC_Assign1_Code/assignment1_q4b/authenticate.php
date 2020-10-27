<?php
    session_start();
    $email;
    $number;
    $pass;
    
    if(isset($_POST['email']))
    {
    $email=$_POST['email'];
    }
    if(isset($_POST['number']))
    {
    $number=$_POST['number'];
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

    require __DIR__ . '/vendor/autoload.php';
    use Twilio\Rest\Client;

    $account_sid = 'AC7f516bcd3f05bfd70a3a0569dd04421c';
    $auth_token = '868f5695c19bd229128a5550dbb5b163';

    $twilio_number = "+12053510512";

    $client = new Client($account_sid, $auth_token);
    $client->messages->create(
        $number,
        array(
            'from' => $twilio_number,
            'body' => $msg
        )
    );
?>

<html>
  <head>
    <title>SEC Assignment 1 :: SMS 2FA</title>
  </head>
  <body>
    <h1>SMS 2FA</h1>
    <form id="comment_form" action="form.php" method="post">
      <input type="text" name="code" placeholder="Type your 6-digit code" size="40"><br><br>
      <input type="submit" name="submit" value="Authenticate">
    </form>
  </body>
</html>