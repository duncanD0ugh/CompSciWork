<?php 
    // Include configuration file 
    include_once 'config.php'; 
    
    // Include database connection file 
    include_once 'dbConnect.php'; 

    session_start();
    $item_name;
    $item_number;
    $amount;
    $image;
    if(isset($_POST['item_name']))
    {
        $item_name = $_POST['item_name'];
    }
    if(isset($_POST['item_number']))
    {
        $item_number = $_POST['item_number'];
    }
    if(isset($_POST['amount']))
    {
        $amount = $_POST['amount'];
    }
    if(isset($_POST['image']))
    {
        $image = $_POST['image'];
    }
?>

<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" 
        href=https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src='https://www.google.com/recaptcha/api.js' async defer></script>
    </head>
    <body>
        <div class="container">
            <h1>Cart</h1>
            <div class="row">
                <img width="150" height="150" src="images/Product_1.jpg"/>
                <div class="col-sm-6">
                    <h5><?php echo $item_name; ?></h5>
                    <h6>Price: <?php echo '$'.$amount ?></h6>
                </div>
            </div>
        </div>
        <form action="checkout.php" method="post">
            <input type="hidden" name="item_name" value="<?php echo $item_name; ?>">
            <input type="hidden" name="item_number" value="<?php echo $item_number; ?>">
            <input type="hidden" name="amount" value="<?php echo $amount; ?>">
            <input type = "submit" value = "Checkout">
        </form>
    </body>
</html>
