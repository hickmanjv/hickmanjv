<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->

<?php	
	/* References: 
			1) http://php.net/manual/en/function.setcookie.php
			2) http://www.w3schools.com/php/php_cookies.asp
	*/

	$cookie_name = "flavor";
	$cookie_value = "Oatmeal Cream Pie";
	
	setcookie($cookie_name, $cookie_value, time() + 3600);
	
	
	$cookie_value = "White macadamia nut"; 
	
	
	setcookie($cookie_name, $cookie_value, time() + 5);	
	
	setcookie($cookie_name, $cookie_value);
	
	setcookie('nick', 'loves cookies');

?>

<html>
	<head>
		<title> setting cookies </title>
	</head>
	<body>
	
	<?php
		
		if(!isset($_COOKIE[$cookie_name])) {
			echo "Cookie name '" . $cookie_name . "' is not set!";
		}
		else {
			echo "Cookie '" . $cookie_name . "' is set! <br>"; 
			echo "Value is: " . $_COOKIE[$cookie_name]; 
		}
	?>
	
	</body>
</html>