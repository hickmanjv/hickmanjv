<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<html>
	<head>
		<title>PHP Arrays 2</title>
	</head>
	<body>
        <?php
            // 2D zoo array
            $zoo = array(
                "cats" => array("Lion", "Tiger", "Cheetah"),
                "acquarium" => array("Sharks", "Jellyfish", "Stingrays"),
                "reptiles" => array("Alligators", "Snakes", "Lizards")
            );
            
            // http://php.net/manual/en/control-structures.foreach.php
            foreach ($zoo as $animalType => $animals) {
                print "$animalType = $animals<br>\n";
                
                foreach ($animals as $animal) {
                    print "- $animal<br>\n";
                }
            }            
        ?>
	</body>
</html>
