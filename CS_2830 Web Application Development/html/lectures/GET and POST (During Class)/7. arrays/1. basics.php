<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<html>
	<head>
		<title>PHP Arrays</title>
	</head>
	<body>
        <?php
            /*
                References:
                    http://php.net/manual/en/function.array.php
                    http://php.net/manual/en/language.types.array.php
            */
            $zoo = array("Monkey", "Tiger", "Crocs", "Penguins");
            
            // 4th index
            $zoo[4] = "Giraffe";
            // end of array
            $zoo[] = "Lion";
        
            // http://php.net/manual/en/function.print-r.php
        
            print_r($zoo);
        
            // http://php.net/manual/en/function.unset.php
        
            unset($zoo[0]);
        
            print_r($zoo);

            // http://php.net/manual/en/function.array-values.php
            
            // re-index the array
            $zoo = array_values($zoo);
            
            print "<ul>\n";
            
            for ($i = 0; $i < count($zoo); $i++) {
                print "<li>{$zoo[$i]}</li>\n";
            }
            
            print "</ul>\n";

        ?>
	</body>
</html>
