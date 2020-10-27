<?php
    session_start();
    $verifyCode = $_SESSION['verifyCode'];
    $code;

    if(isset($_POST['code']))
    {
      $code=$_POST['code'];
    }

    if($code == $verifyCode)
    {
        echo '<div class="alert alert-success">
			  		<strong>Success!</strong> Your email has been verified.
		 		  </div>';
    }
    else
    {
        echo '<div class="alert alert-warning">
                    <strong>Error!</strong> Code Error: Email was not verified.
                  </div>';
    }
?>

