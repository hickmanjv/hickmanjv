<?php
	/* Created by Professor Wergeles for CS2830 at the University of Missouri */
   

    // Print the contents of $_GET
    print_r($_GET);
    
    // looking for a 'name' key
    $name = $_GET['name'];

    // looking for a 'language' key
    $language = $_GET['language'];

    print "<br><br>"; 
    
    
    // If the language is Chinese, say hi in Chinese
    if ($language == 'ch') {
        print "Ni Hao $name";
    }
    // Else default to English
    else {
        print "Hello $name";
    }
?>
