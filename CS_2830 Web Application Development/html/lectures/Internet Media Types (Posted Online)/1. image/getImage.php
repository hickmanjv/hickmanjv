<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri


	header('Content-type: image/jpeg');

	$handle = fopen('funny.jpg', 'rb');

	$bufferLen = 8192;

	while ($buffer = fread($handle, $bufferLen)) {
		print $buffer;
	}
	
	fclose($handle);
?>