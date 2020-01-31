<?php

handle_order();

function handle_order(){
        
        $name = empty($_GET['name1']) ? '' : $_GET['name1'];
            setcookie('name1', $name);
        $address = empty($_GET['street']) ? '' : $_GET['street'];
            setcookie('street', $address);
        $city = empty($_GET['city']) ? '' : $_GET['city'];
            setcookie('city', $city);
        $zipcode = empty($_GET['zip']) ? '' : $_GET['zip'];
            setcookie('zip', $zipcode);
    
        header('Location: success.php');
        exit;

    }

?>