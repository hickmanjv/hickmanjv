<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri


    // Print the contents of $_POST this time
    print_r($_POST);
    
    // looking for a 'name' key
    $name = $_POST['name'];

    // looking for a 'language' key
    $language = $_POST['language'];

    print "<br><br>"; 
    
    
    // If the language is Chinese, say hi in Chinese
    if (strcmp($language, 'ch') == 0) {
        print "Ni Hao $name";
    }
    // Else default to English
    else {
        print "Hello $name";
    }

?>