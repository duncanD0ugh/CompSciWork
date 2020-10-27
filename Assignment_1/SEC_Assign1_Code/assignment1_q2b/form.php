<?php
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
	if(isset($_POST['post']))
	{
		$url = "https://www.google.com/recaptcha/api/siteverify";
		$data = [
			'secret' => "6LceWcEZAAAAAKpDmK7uGUA-LKJ8FJufGHW08sxZ",
			'response' => $_POST['token'],
		];

		$options = array(
		    'http' => array(
		      'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
		      'method'  => 'POST',
		      'content' => http_build_query($data)
		    )
		  );

		$context  = stream_context_create($options);
  		$response = file_get_contents($url, false, $context);
		$responseKeys = json_decode($response, true);

		if($responseKeys['success'] == true)
		{
  			echo '<div class="alert alert-success">
			  		<strong>Success!</strong> Your inquiry successfully submitted.
		 		  </div>';
		}
		else 
		{
			echo '<div class="alert alert-warning">
					  <strong>Error!</strong> You are not a human.
				  </div>';
		}
	}

?>