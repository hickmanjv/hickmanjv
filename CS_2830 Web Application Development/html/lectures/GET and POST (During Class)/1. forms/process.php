<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri 

    /*
        References:
            http://www.w3schools.com/tags/ref_httpmethods.asp
            http://php.net/manual/en/reserved.variables.php
    */
    
    if($_SERVER['REQUEST_METHOD'] === 'GET') {
        print "\nThe server request method is GET!\n\n<br><br>";
        
        foreach ($_GET as $key => $value) {
            print "$key = $value<br>\n";
        }
    }
    
    

?>
