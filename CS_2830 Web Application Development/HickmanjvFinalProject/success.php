<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="header.css">
        <link rel="stylesheet" type="text/css" href="successCSS.css">
        <title>Order Placed!</title>
        
        <script>
        
            function getCoupon(){
                
                var xmlHttp = new XMLHttpRequest();
                
                xmlHttp.onreadystatechange = function(){
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        
                        var response = xmlHttp.responseText;
                        
                        var contentBox = document.getElementById("couponWindow");
                        contentBox.innerHTML = response;
                    }
                };
                
                xmlHttp.open("GET", "coupon.php", true);
                
                xmlHttp.send();
            }
        
        </script>
        
    </head>
    <body>
        <div id="header">
            <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I H<img id="logo" src="http://ec2-13-59-86-243.us-east-2.compute.amazonaws.com/HickmanjvFinalProject/Images/Logo.png" alt="Fire Logo">te Cooking<form action="logout.php">
            <button id="logButton" type="submit" onclick="logout.php">Logout</button></form></h1>
            
        </div>
        
        <div class="Wrapper">
            <h2>Order Successfully Placed!</h2>
            <h2>Your order will be delivered to...</h2>
            <div class="success">
                <?php
                    $name = empty($_COOKIE['name1']) ? '' : $_COOKIE['name1'];
                    echo "Name: $name";
                ?>
            </div>
            <div class="success">
                <?php
                    $address = empty($_COOKIE['street']) ? '' : $_COOKIE['street'];
                    echo "Address: $address";
                ?>
            </div>
            
            <div class="success">
                <?php
                    $city = empty($_COOKIE['city']) ? '' : $_COOKIE['city'];
                    echo "City: $city";
                ?>
            </div>
            
            <div class="success">
                <?php
                    $zipcode = empty($_COOKIE['zip']) ? '' : $_COOKIE['zip'];
                    echo "Zipcode: $zipcode";
                ?>
            </div>
            
            <div id="couponButton">
                <button id="logButton" onclick=getCoupon()>Free Coupon</button>
            </div>
            
            <div id="wrapBox">
                <div id="couponWindow">
                
                </div>
            </div>
        </div>
    </body>
</html>