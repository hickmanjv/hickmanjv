<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<html>
	<head>
		<title>Content Navigator</title>
        <link rel="stylesheet" href="app.css" type="text/css">
	</head>
	<body>
        <div id="wrapper" class="group">
            <h1>Content Navigator</h1>
            <hr>
            <ul id="menu">
                <li><a href="index.php?content=1">Content #1</a></li>
                <li><a href="index.php?content=2">Content #2</a></li>
                <li><a href="index.php?content=3">Content #3</a></li>
            </ul>
            <div id="display">
                <?php
                    
                    // ternary operator
                    $content = empty($_GET['content']) ? 1 : $_GET['content'];


                    if ($content == 1) {
                        print "<h2>Content 1</h2>";
                        print "<div class=\"imgPlaceholder orange\"></div>";
                        print "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dapibus mollis mollis. Vivamus tincidunt, arcu eget maximus accumsan, velit nisi mattis nibh, vel semper sem quam nec lectus. Nam et enim tempor augue luctus laoreet. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>";
                    }

                    elseif ($content == 2) {
                        print "<h2>Content 2</h2>";
                        print "<div class=\"imgPlaceholder purple\"></div>";
                        print "<p>Donec ornare sapien nulla, eget eleifend metus scelerisque ac. Suspendisse potenti. In a dui quis mauris sollicitudin tempus. Integer tincidunt sapien id velit lacinia posuere. Nunc eleifend, dui non blandit pretium, urna purus consequat tellus, sit amet scelerisque nisl eros non purus. Cras mi ipsum, efficitur eget pretium a, consequat eget sapien.</p>";
                    }

                    elseif( $content == 3) {
                        print "<h2>Content 3</h2>";
                        print "<div class=\"imgPlaceholder green\"></div>";
                        print "<p>Sed vel viverra quam, a faucibus felis. Nulla elit tellus, interdum in eros sit amet, suscipit molestie metus. Proin dignissim a mauris venenatis luctus. Nulla quis purus vitae ipsum varius fringilla vel a nisl. Sed suscipit, ligula quis blandit varius, turpis felis iaculis neque, quis sagittis eros lacus a dui.</p>";
                    }
                    
                ?>
            </div>
        </div>
	</body>
</html>