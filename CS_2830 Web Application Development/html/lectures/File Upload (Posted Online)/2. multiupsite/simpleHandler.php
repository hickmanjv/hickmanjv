<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

    // Let's look at the contents of $_FILES to see how our data is structured
    foreach ($_FILES as $key => $value) {
        print "$key = $value<br>\n";
    }

    // $_FILES['files'] contains an array of arrays
    $myFiles = $_FILES['files'];

    foreach ($myFiles as $fileCategory => $categoryArray) {
        print "- $fileCategory = $categoryArray<br>\n";

        foreach ($categoryArray as $categoryKey => $categoryValue) {
            print "-- $categoryKey = $categoryValue<br>\n";
        }

        print "<br>\n";
    }
?>
