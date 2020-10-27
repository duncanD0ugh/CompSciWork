<?php 
// Include configuration file 
include_once 'config.php'; 
 
// Include database connection file 
include_once 'dbConnect.php'; 
?>
<html>
    <head>
        <title>Products</title>
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
            <h1>Products</h1>

            <?php  
                // Fetch products from the database 
                $results = $db->query("SELECT * FROM products WHERE status = 1"); 
                while($row = $results->fetch_assoc()){ 
            ?>
            <div class="row">
                <img width="150" height="150" src="images/<?php echo $row['image']; ?>"/>
                <div class="col-sm-6">
                    <h5><?php echo $row['name']; ?></h5>
                    <h6>Price: <?php echo '$'.$row['price'].' '.PAYPAL_CURRENCY; ?></h6>
                
                    <form action="cart.php" method="post">
                        <input type="hidden" name="business" value="<?php echo PAYPAL_ID; ?>">
                        
                        <!-- Specify a Buy Now button. -->
                        <input type="hidden" name="cmd" value="_xclick">

                        <input type="hidden" name="item_name" value="<?php echo $row['name']; ?>">
                        <input type="hidden" name="item_number" value="<?php echo $row['id']; ?>">
                        <input type="hidden" name="amount" value="<?php echo $row['price']; ?>">
                        <input type="hidden" name="image" value="<?php echo $row['image']; ?>">
                        <input type = "submit" value = "Buy Now!">
                    </form>
                </div>
            </div>
            <?php } ?>
        </div>
    </body>
</html>