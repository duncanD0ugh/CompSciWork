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
		<div class=container>
			<div class="container loginForm">
				<form method='post' action="https://titan.csit.rmit.edu.au/~e54061/wp/processing.php?ref=login">
					<p class='formRow'>
						<label for="email">Email:</label>
						<input class='formInput' type='email' id="email" name='email' placeholder='example@email.com' required>
						<br>
						<br>
					</p>
					<p class='formRow'>
						<label for="password">Password:</label>
						<input class='formInput' type="password" id="password" name="password" required>
						<br>
						<br>
					</p>
					<p class='formRow'></p>
					<input class='formInput' type="submit" value="Log in">
				</form>
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