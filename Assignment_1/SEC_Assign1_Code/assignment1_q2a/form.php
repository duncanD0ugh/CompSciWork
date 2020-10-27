<?php
        $email;
        $pass;
        $captcha;

        if(isset($_POST['email']))
        {
          $email=$_POST['email'];
        }
        if(isset($_POST['pass']))
        {
          $pass=$_POST['pass'];
        }
        if(isset($_POST['g-recaptcha-response']))
        {
          $captcha=$_POST['g-recaptcha-response'];
        }
        if(!$captcha)
        {
          echo '<h2>Please check the Captcha in the form. Go Back !!!</h2>';
          exit;
        }

        $secretKey = "6LcWG7oZAAAAAGkkz2HSU9qmpovRyXuxc0_ewHBj";
        $ip = $_SERVER['REMOTE_ADDR'];

        $url = 'https://www.google.com/recaptcha/api/siteverify?secret=' . urlencode($secretKey) .  '&response=' . urlencode($captcha);
        $response = file_get_contents($url);
        $responseKeys = json_decode($response,true);
        
        if($responseKeys["success"]) 
        {
                echo '<h2>Thanks for submitting your information.</h2>';
        }
        else 
        {
                echo '<h2>Your are a spammer!!!</h2>';
        }
?>