<!DOCTYPE html>
<html lang='en'>

<head>
	<meta charset="utf-8">
	<title>Assignment 2</title>
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
			</ul>
		</div>
	</nav>
	<main>
		
		<div class='container gridContainer'>
			<!-- Image source: https://db.fortnitetracker.com/weapons -->
			<img class='productImg' src='../../media/BoltAction.png' alt='Bolt Action Sniper Rifle' />
			<div>
				<h1>Bolt Action Sniper Rifle</h1>
				<p class=block>The sniper rifle is a gun necessary for all first and third person shooters. Having been around for as long as shooter style games have existed, it is a necessary part of any players loadout. In fortnite, it is an a massive advantage to have access to a long ranged sniper rifle and when well utilised, taking out the enemy holed up in a base can be done with ease.</p>
			</div>
			<h1> $1.99 AUD</h1>
			<div>
				<form id=purchaseDetails method='post' onsubmit='return validateForm()' action='https://titan.csit.rmit.edu.au/~e54061/wp/processing.php?ref=product'>
					<input type=hidden name='id' value='BoltSniper'>Rarity
					<select id=selectBoxStyle class=block name='option'>
						<option id=rareOption value="Rare">Rare (blue)</option>
						<option id=epicOption value="Epic">Epic (purple)</option>
						<option id=legendaryOption value="Legendary">Legendary (gold)</option>
					</select>
					<div id=qtyStyle class=gridContainerQty>
						<button type='button' onclick='decrease()'>-</button>
						<input id="qty" type='text' name='qty' value='1'>
						<button type='button' onclick='increase()'>+</button>
					</div>
					<button id=submitButtonStyle class=maxWidth type='submit'>Buy</button>
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