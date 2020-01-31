
<?php

// Help from lectures of Professor Wergeles

    $action = empty($_POST['action']) ? '' : $_POST['action'];

    if($action === 'do_login'){
        handle_login();
    }
    else{
        loginForm();
    }

    function handle_login(){
        
        $username = empty($_POST['username']) ? '' : $_POST['username'];
        $password = empty($_POST['password']) ? '' : $_POST['password'];
        
        if($username === "test" && $password === "pass"){
            setcookie('username', $username);
            header('Location: orderpage.php');
            exit;
        }
        else{
            $error = "Error: Incorrect username or password";
            require "loginForm.php";
        }

    }

    function loginForm(){
        
        $username = "";
        $error = "";
        require "loginForm.php";
    }
?>