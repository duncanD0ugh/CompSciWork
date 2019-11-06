<?php
    function topModule($pageTitle) 
    {
        $html = <<<"TOP"
        <!DOCTYPE html>
        <html lang='en'>
        
        <head>
            <meta charset="utf-8">
            <title>$pageTitle</title>
            <!-- Keep wireframe.css for debugging, add your css to style.css -->
            <link id='wireframecss' type="text/css" rel="stylesheet" href="../wireframe.css" disabled>
            <link id='stylecss' type="text/css" rel="stylesheet" href="css/style.css">
            <script src='../wireframe.js'></script>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Anton">
        </head>
        
        <body>
            <header>
                <div class=container>
                    <!-- Image source: https://toppng.com/photo/20029/fortnite-battle-royale-logo -->
                    <a href="index.php">
                        <img src='../../media/logo.png' alt='Fortnite BR Shop Logo' />
                    </a>
                    <h1>Fortnite Battle Royale Shop</h1>
                </div>
            </header>
            <nav>
                <div class=container>
                    <ul>
                        <li><a href="index.php">Home</a>
                        </li>
                        <li><a href="products.php">Shop</a>
                        </li>
                        <li><a href="login.php">Login</a>
                        </li>
                        <li><a href="cart.php">Cart</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main>
TOP;
        echo $html; 
    }

    // function readTextFile($fileName)
    // {
    //     $fp = fopen($fileName,'r'); 
    //     if (($headings = fgetcsv($fp, 0, "\t")) !== false) 
    //     { 
    //         while ( $cells = fgetcsv($fp, 0, "\t") ) 
    //         { 
    //             for ($x=1; $x<count($cells); $x++)
    //             {
    //                 $products[$cells[0]][$cells[1]][$headings[$x]]=$cells[$x]; 
    //             }
    //         } 
    //     } 
    //     fclose($fp);
    // }

    function preShow($arr, $returnAsString=false) 
    {
        $ret  = '<pre>' . print_r($arr, true) . '</pre>';
        if ($returnAsString)
        {
            return $ret;
        }
        else
        {
            echo $ret; 
        }
    }     

    function printMyCode() 
    {
        $lines = file($_SERVER['SCRIPT_FILENAME']);
        echo "<pre class='mycode'>\n";
        foreach ($lines as $lineNo => $lineOfCode)
        {
           printf("%3u: %1s \n", $lineNo, rtrim(htmlentities($lineOfCode)));
        }
        echo "</pre>";
      }
      
    function ProductsPage($image, $id, $title, $desc, $i)
    {
        $html =  <<<"TOP"
        <div class=productDiv>
        <a href="products.php?id=$id">
            <img class="imgLeftFloat" src="../../media/$image"> 
        </a>
        <h1 class=productImgPadding>$title</h1>
        <p class=productsText>
        <br>$desc</p>
    </div>
TOP;
        if ($i % 2 == 0)
        { ?>
            <div class="container gridContainerProducts">
        <?php echo $html;
        } else 
        {
            echo $html; ?>
            </div> <?php
        }      
    }

    function endModule() 
    {
        $html = <<<"TOP"
        <footer>
                <div class=container>
                    <p>&copy;
                        <script>
                            document.write(new Date().getFullYear());
                        </script>Erick Blucher (s3723054), Duncan Do (s3718718) Error 404; Webpage not found
                        <br>Disclaimer: This website is not a real website and is being developed as part of a School of Science Web Programming course at RMIT University in Melbourne, Australia.
                        <br>
                        <button id='toggleWireframeCSS' onclick='toggleWireframe()'>Toggle Wireframe CSS</button>
                    </p>
                </div>
        </footer>
    </body>
</html>
TOP;
        echo $html;
        preShow($_POST);
        preShow($_SESSION);
        printMyCode();
    }

    function cartDivs($id, $option, $qty, $image)
    {
        $html = <<<"TOP"
            <div class="container gridContainerProducts">
                <div class=productDiv>
                    <a href="products.php?id=$id">
                        <img class="imgLeftFloat" src="../../media/$image"> 
                    </a>
                    <h1 class=productImgPadding>$id</h1>
                    <p class=productsText>
                    <br>Rarity: $option</p>
                    <br>Quantity: $qty</p>
                </div>
            </div>
TOP;
            echo $html;
    }

    function productPage($image, $id, $title, $desc, $price) 
    {
        $html = <<<"TOP"
        <div class='container gridContainer'>
            <!-- Image source: https://db.fortnitetracker.com/weapons -->
            <img class='productImg' src='../../media/$image' name='image' value=$image alt='$id' />
            <div>
                <h1>$title</h1>
                <p class=block>$desc</p>
            </div>
            <h1 id='price'>&#36;$price</h1>
            <div>
                <form id=purchaseDetails method='post' onsubmit='return validateForm()' action='cart.php'>
                    <input type=hidden name='id' value='$id'>Rarity
                    <select id=selectBoxStyle class=block name='option'>
                        <option id=rareOption value="Rare">Rare (blue)</option>
                        <option id=epicOption' value="Epic">Epic (purple)</option>
                        <option id=legendaryOption value="Legendary">Legendary (gold)</option>
                    </select>
                    <div id=qtyStyle class=gridContainerQty>
                        <button type='button' onclick='decrease()'>-</button>
                        <input id="qty" type='text' name='qty' value='1'>
                        <button type='button' onclick='increase()'>+</button>
                    </div>
                    <button name='add' id=submitButtonStyle class=maxWidth type='submit'>Add to Cart</button>
                </form>
            </div>
        </div>
            
        <script>
            function increase(){
                    var x = document.getElementById("qty").value;
            
                    if (!isNaN(x) && x >= 0) { //Checking if current number is negative, so won't increment to another negative 
                        document.getElementById("qty").value = parseInt(x) + 1;
                    }
                    else {
                    document.getElementById("qty").value = 1;
                    }
                    document.getElementById("price").innerHTML = "$" + (document.getElementById("qty").value * $price);
                }
        </script>
        <script>
            function decrease(){
                    var x = document.getElementById("qty").value;
            
                    if (!isNaN(x) && x >= 1) { // Checking if at least 1, won't decrement below 0 
                        document.getElementById("qty").value = parseInt(x) - 1;
                    }
                    else {
                    document.getElementById("qty").value = 1;
                    }
                    document.getElementById("price").innerHTML = "$" + (document.getElementById("qty").value * $price);
                }
        </script>
        <script>
            function validateForm(){
                var x = document.getElementById("qty").value;
                if (isNaN(x)) { //Checking if value is NaN
                        return false;
                }
                if (x <= 0) { // Checking for 0 or negative integer
                        return false; 
                }
                if (Math.floor(x) != x) { //Checking decimal)
                        return false;
                }
                }
        </script>
        </main>
TOP;
        echo $html;
    }


?>