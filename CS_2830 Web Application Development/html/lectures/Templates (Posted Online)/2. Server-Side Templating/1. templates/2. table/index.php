<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

	// Require the Template class
	require_once('Template.php');
	
	// Create some associative arrays and store them in a $users array
	$users = array();
	$users[] = array('school' => 'MU', 'name' => 'John Smith', 'age' => 24, 
		'gender' => 'male');
	$users[] = array('school' => 'KU', 'name' => 'Sally Smith', 'age' => 25, 
		'gender' => 'female');
	$users[] = array('school' => 'KSU', 'name' => 'Karen Smith', 'age' => 23, 
		'gender' => 'female');
	
	// Instantiate a new Template object
	$t1 = new Template();
	// Pass the $users array to that Template
	$t1->users = $users;
	
	// Build usersTable.tmpl and store the output
	$tableHTML = $t1->build('usersTable.tmpl');
	
	// Output to the client
	print $tableHTML;
?>
