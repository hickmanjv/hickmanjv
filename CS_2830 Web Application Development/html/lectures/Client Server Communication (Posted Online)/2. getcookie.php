<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

	// The predefined $_COOKIE array contains our cookies
	// Reference: http://php.net/manual/en/reserved.variables.cookies.php

	$flavor = $_COOKIE['flavor'];
	
	$flavor = empty($_COOKIE['flavor']) ? "The cookie 'flavor' does not exist." : $_COOKIE['flavor'];
	
	print "Flavor = $flavor<br>\n";
?>