<!DOCTYPE html>

<html>
    <head>
        <title>Order Online</title>
        <link rel="stylesheet" type="text/css" href="order.css">
        <link rel="stylesheet" type="text/css" href="header.css">
    </head>
    <body>
        <div id="header">
            <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I H<img id="logo" src="http://ec2-13-59-86-243.us-east-2.compute.amazonaws.com/HickmanjvFinalProject/Images/Logo.png" alt="Fire Logo">te Cooking<form action="logout.php">
            <button id="logButton" type="submit" onclick="logout.php">Logout</button></form></h1>
            
        </div>
        
        <div class="Welcome">
            <?php
                $username = empty($_COOKIE['username']) ? '' : $_COOKIE['username'];
                echo "Welcome Back: $username";
            ?>
        </div>
        
        <div class="Welcome">
            <?php
                echo "Login Successful!";
            ?>
        </div>
        
        <div class="wrap1">
            <form action="handleOrder.php" method="GET">
                
                <div id="rest" class="orderInfo">
                    <input type="radio" name="rest" value="apple" checked> Applebees<br>
                    <input type="radio" name="rest" value="trh"> Texas Roadhouse<br>
                    <input type="radio" name="rest" value="og"> Olive Garden
                </div>
            
                <div id="nameId" class="orderInfo">
                    <label for="name">Name</label>
                    <input type="text" id="name1" name="name1">
                </div>
            
                <div id="streetId" class="orderInfo">
                    <label for="streeAddress">Address</label>
                    <input type="text" id="street" name="street">
                </div>
                
                <div id="cityId" class="orderInfo">
                    <label for="City">City</label>
                    <input type="text" id="city" name="city">
                </div>
                
                <div id="zipId" class="orderInfo">
                    <label for="zip">Zipcode</label>
                    <input type="text" id="zip" name="zip">
                </div>
                
                <div class="order">
                    <button id="orderButton" type="submit">Order Now</button>
                </div>

            </form>
        </div>

        
    </body>
</html>