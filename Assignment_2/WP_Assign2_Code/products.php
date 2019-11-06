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
		<div class="container gridContainerProducts">
			<div class=productDiv>
			<!-- Image source: https://db.fortnitetracker.com/weapons -->
			<img class=imgLeftFloat src='../../media/SCAR.png'>
				<h1 class=productImgPadding>SCAR</h1>
				<p class=productsText>
					<br>The gun for almost any situation. From gatekeeping the circle from a base, or laying seige to said base; this gun will give you the edge in battle.</p>
			</div>
			<div class=productDiv>
			<!-- Image source: https://db.fortnitetracker.com/weapons -->
			<img class=imgLeftFloat src='../../media/PumpShotgun.png'>
				<h1 class=productImgPadding>Pump</h1>
				<p class=productsText>
					<br>Best for those build battles and close quater combat. No need to continuously spray your enemies down; a single pump can do the trick.</p>
			</div>
			<div class=productDiv>
				<a href=product.php>
					<!-- Image source: https://db.fortnitetracker.com/weapons -->
					<img class=imgLeftFloat src='../../media/BoltAction.png'>
				</a>
				<h1 class=productImgPadding>Sniper</h1>
				<p class=productsText>
					<br>Take out enemies with a single shot from too far for them to hit back. Also the perfect gun to trick shot your foes. Mid-air, 360 or even no scope.</p>
			</div>
			<div class=productDiv>
				<!-- Image source: https://db.fortnitetracker.com/weapons -->
				<img class=imgLeftFloat src='../../media/CompactGun.png'>
				<h1 class=productImgPadding>P90</h1>
				<p class=productsText>
					<br>Mow down enemies and buildings in seconds. Watch as your continous spray destroys your enemies defences and chances of winning.</p>
			</div>
		</div>
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