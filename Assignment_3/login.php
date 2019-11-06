<?php
	session_start();
	include_once('tools.php');
	topModule('Login');
?>
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
<?php
	endModule();
?>