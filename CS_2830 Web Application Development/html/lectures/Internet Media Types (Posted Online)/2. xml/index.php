<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri
//The main point of this code is to show you that MIME types can be more than just text/html


	header('Content-type: text/xml');

	$handle = fopen("movies.xml", "r");

	$bufferLen = 8192;

	while($buffer = fread($handle, $bufferLen)) {
    	print $buffer;
	}

	fclose($handle);	
?>
