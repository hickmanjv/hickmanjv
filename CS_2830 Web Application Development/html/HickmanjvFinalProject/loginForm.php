<!DOCTYPE html>

<!--

    Help with this part from lectures of Professor Wergeles

-->

<html lang="en">
    <head>
        <title>Login</title>
        
        <!-- Help with the jQuery part of the UI came from Professor Wergeles lectures, and the TAs  -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css">
        <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" type="text/css" href="widget.css">
        <link rel="stylesheet" type="text/css" href="header.css">
        
        <script>
            $(function(){
                $("input[type=submit]").button();
            });
        </script>
    </head>
    <body>
        
        <div id="header">
            <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I H<img id="logo" src="http://ec2-13-59-86-243.us-east-2.compute.amazonaws.com/HickmanjvFinalProject/Images/Logo.png" alt="Fire Logo">te Cooking</h1>
        </div>
        
        <?php
            $username = empty($_COOKIE['username']) ? '' : $_COOKIE['username'];

            if($username){
                header("Location: orderpage.php");
                exit;
            }
        ?>
        
        <div id="loginWidget" class="ui-widget">
            <h1 class="ui-widget-header">Login</h1>
        
            <?php
                if ($error) {
                    print "<div class=\"ui-state-error\">$error</div>\n";
                }
            ?>
        
            <form action="login.php" method="POST">
            
                <input type="hidden" name="action" value="do_login">
            
                <div class="stack">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" class="ui-widget-content ui-corner-all" autofocus value="<?php print $username; ?>">
                </div>
            
                <div class="stack">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="ui-widget-content ui-corner-all">
                </div>
            
                <div class="stack">
                    <input id="subButton" type="submit" value="Submit">
                </div>
            </form>
        </div>
    </body>
</html>