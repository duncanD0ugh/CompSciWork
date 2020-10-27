<?php

    // Start Session
    session_start();

    // check user login
    if(empty($_SESSION['user_id']))
    {
        header("Location: index.php");
    }

    // Load PHP files for Database connection
    require 'db_connection.php';
    $db = DB();

    // Load the operation implementations ( i.e., Operation class )
    require 'operation.php';
    $app = new Operation($db);
    $user = $app->UserDetails($_SESSION['user_id']);

?>
<!doctype html>
<html lang="en">
<body>
	<h1>Google's 2 Factor Authentication System</h1>
    <h2>User Profile</h2>
    <h3>Welcome <?php echo $user->name; ?></h3>
    <p>Account Details:</p>
    <p>Name: <?php echo $user->name; ?></p>
    <p>Username <?php echo $user->username; ?></p>
    <p>Email <?php echo $user->email; ?></p>
    <br>
    Click here to <a href="logout.php">Logout</a>
</body>
</html>