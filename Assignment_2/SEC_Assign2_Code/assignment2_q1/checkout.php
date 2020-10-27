<?php 
    // Include configuration file 
    include_once 'config.php'; 
    
    // Include database connection file 
    include_once 'dbConnect.php'; 

    session_start();
    $item_name;
    $item_number;
    $amount;
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
?>

<html>
    <head>
        <title>Checkout</title>
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
            <h1>Checkout</h1>
            <div class="row">
            <img width="150" height="150" src="images/Product_1.jpg"/>
                <div class="col-sm-6">
                    <h5><?php echo $item_name; ?></h5>
                    <h6>Price: <?php echo '$'.$amount ?></h6>
                </div>
            </div>
        </div>

        <!-- Paypal payment -->
        <!-- PayPal payment form for displaying the buy button -->
        PAYPAL<form action="<?php echo PAYPAL_URL; ?>" method="post">
            <!-- Identify your business so that you can collect the payments. -->
            <input type="hidden" name="business" value="<?php echo PAYPAL_ID; ?>">
					
            <!-- Specify a Buy Now button. -->
            <input type="hidden" name="cmd" value="_xclick">
					
            <!-- Specify details about the item that buyers will purchase. -->
            <input type="hidden" name="item_name" value="<?php echo $item_name; ?>">
            <input type="hidden" name="item_number" value="<?php echo $item_number; ?>">
            <input type="hidden" name="amount" value="<?php echo $amount; ?>">
            <input type="hidden" name="currency_code" value="<?php echo PAYPAL_CURRENCY; ?>">
			
            <!-- Specify URLs -->
            <input type="hidden" name="return" value="<?php echo PAYPAL_RETURN_URL; ?>">
            <input type="hidden" name="cancel_return" value="<?php echo PAYPAL_CANCEL_URL; ?>">
            <input type="hidden" name="notify_url" value="<?php echo PAYPAL_NOTIFY_URL; ?>">
					
            <!-- Display the payment button. -->
            <input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif">
        </form>
        
        <!-- Google Pay payment -->
        <div id="container">
            GOOGLE PAY
            <div class="row">
                <div class="col-sm-6">
                    <script src="checkout.js"></script>
                    <script async src="https://pay.google.com/gp/p/js/pay.js" onload="onGooglePayLoaded()"></script>
                </div>
            </div>
        </div>

        <!-- Direct Card Payment -->
        CREDIT CARD DIRECT
        <form action="paymentProcess.php?pid=1" method="POST">
            <script
                src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                data-key="pk_test_InwOqy624uXwfN2dgqlCR2gI"
                data-amount="<?php echo $amount*100; ?>"
                data-name="<?php echo $item_name; ?>"
                data-description="Some PC"
                data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                data-locale="auto"
                data-currency="aud">
            </script>
        </form>

        <form method="POST" action="index.php">
            <input type="submit" value="Back to Products"/>
        </form>
    </body>
</html>