<html>
  <head>
    <title>SEC Assignment 1 :: Google reCaptcha V3</title>
    <script src="https://www.google.com/recaptcha/api.js?render=6LceWcEZAAAAADtqRGIipaXFIEs3fIv3n_KHyb8L"></script>
  </head>
  <body>
    <h1>Google reCAPTHA V3</h1>
    <form id="comment_form" action="form.php" method="post">
      <input type="email" name="eemail" placeholder="Type your email"><br><br>
      <input type="password" name="pass" placeholder="Type your password"><br><br>
      <input type="submit" value="Post" class="btn btn-success btn-block" name="post">
      <input type="hidden" id="token" name="token"> 
    </form>
  </body>
  <script>
  grecaptcha.ready(function() 
  {
      grecaptcha.execute('6LceWcEZAAAAADtqRGIipaXFIEs3fIv3n_KHyb8L', {action: 'homepage'}).then(function(token) 
      {
         document.getElementById("token").value = token;
      });
  });
  </script>
</html>

