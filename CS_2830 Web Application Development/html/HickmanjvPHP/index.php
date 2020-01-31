<!DOCTYPE html>

<!--
    name: Josh Hickman
    pawprint: hickmanjv
    assignment: Challenge 8
-->

<html lang="en">
    <head>
        <title>PHP Examples</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="all" href="challenge8CSS.css">
    </head>
    <body>
        <!-- Navigation Bar -->
        <div class="navbar">
            <ul class="nav1">
                <li class="nav2"><a class="active" href="index.php" target="_self">Home</a></li>
                <li class="nav2"><a href="../HickmanjvSettingUp.html" target="_self">Challenge 1</a></li>
                <li class="nav2"><a href="../HickmanjvHNavbarBio.html" target="_self">Challenge 2</a></li>
                <li class="nav2"><a href="../HickmanjvColumns.html" target="_self">Challenge 3</a></li>
                <li class="nav2"><a href="../HickmanjvTables.html" target="_self">Challenge 4</a></li>
                <li class="nav2"><a href="../HickmanjvEditor.html" target="_self">Challenge 6</a></li>
                <li class="nav2"><a href="../index.html" target="_self">Challenge 7</a></li>
            </ul>
        </div>
        
        <div class="container">
        
            <?php
                // variables    
                $myFunction = $_GET['myFunction'];
                $x = $_GET['x'];
                $a = $_GET['a'];
                $b = $_GET['b'];
                $name = NULL;
                $temp = $x;
                $temp2 = 1;

                // function to pull name from address bar and echo to the screen with formatting
                function sayHi(){
                    $name = $_GET['name'];
                    
                    if($name == NULL){
                        echo '<h2>Hi, how about you give me your name?</h2>';
                    }
                    else{
                        echo '<h2>Hi ' . $name . ', what can I do for you?</h2>';
                    }  
                }
            
                // function to display a picture from the file folder
                function showPic(){
                    echo '<img class="pic" src="cool.gif" alt="Cool Picture dude!" width="50%" height="auto" >';
                }
            
                // function to open a file and display as unordered list, then close the file
                function showList(){
                    $listFile = fopen("list.txt", "r") or die("Unable to open file!");
                        
                        echo '<ul>';
                        while(!feof($listFile)){
                            echo '<li>' . fgets($listFile) . '</li><br>';
                        }
                        echo '</ul>';
                    
                    fclose($listFile);
                }
            
                // function to determine if provided number is a hamming number or not
                // help with this function came from https://www.w3resource.com/php-exercises/challenges/1/php-challenges-1-exercise-20.php
                function hamming($x){
                    global $x;
                    global $temp;
                   
                    if($temp == NULL){
                        return 0;
                    }
                    
                    if($temp == 1){
                        return 1;
                    }
                    
                    if($temp % 2 == 0){
                        $temp = $temp/2;
                        return hamming($temp);
                    }
                    
                    if($temp % 3 == 0){
                        $temp = $temp/3;
                        return hamming($temp);
                    }
                    
                    if($temp % 5 == 0){
                        $temp = $temp/5;
                        return hamming($temp);
                    }
                    
                    return 2;
                }
            
                // function to print out the sequence of hamming numbers up to and including entered hamming number value
                // previous help for hamming function wasn't useful for our type of exercise
                function hammingSeq($x){
                    global $x;
                    $tempx = $x;
                    
                    $result2 = hamming($x);
                    
                    if($result2 == 0){
                        return 0;
                    }
                    else if($result2 == 2){
                        return 2;
                    }
                    else{
                        $x = 2;
                        
                        for($x; $x <= $tempx; $x++){
                            
                            $temp2 = $x;
                            $result2 = hamming(temp2);   // this isn't working, when it gets to 7, $result should be 2 but it isn't
                            
                            if($result2 == 1){
                                echo $x . ', ';
                            }
                        }
                    }
                    
                    return 1;
                }
            
                // function to determing if 2 strings are anagrams
                function anagram($a, $b){
                    global $a, $b;
                    
                    if($a == NULL || $b == NULL){
                        echo '<h2>Error! There needs to be at least 2 words to compare for anagram function!</h2>';
                    }
                    else{
                        if(count_chars($a, 1) === count_chars($b,1)){
                            echo '<h2>The words ' . $a . ' and ' . $b . ' are an anagram!</h2>';
                        }
                        else{
                            echo '<h2>The words ' . $a . ' and ' . $b . ' are NOT an anagram!</h2>';
                        }
                    }
                    
                }
            
                // formatted display of different functions from address bar
                if($myFunction == 'sayHi'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    sayHi();
                }
                else if($myFunction == 'showPic'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    showPic();
                }
                else if($myFunction == 'showList'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    showList();
                }
                else if($myFunction == 'hamming'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    $result = hamming($x);
                    
                        if($result == 0){
                            echo '<h2>Error! Function requires a number to run, please try again!</h2>';
                        }
                        else if($result == 1){
                            echo '<h2>' . $x . ' is a Hamming Number!</h2>';
                        }
                        else{
                            echo '<h2>' . $x . ' is NOT a Hamming Number!</h2>';
                        }
                }
                else if($myFunction == 'hammingSeq'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    $result = hammingSeq($x);
                    
                    if($result == 0){
                        echo '<h2>Error! Function requires a number to run, please try again!</h2>';
                    }
                    else if($result == 2){
                        echo '<h2>' . $temp . ' is NOT a Hamming Number!</h2>';
                    }
                    else{
                        
                    }
                    
                }
                else if($myFunction == 'anagram'){
                    echo '<div class="header"> <h1>You are using function: ' . $myFunction . '</div>';
                    anagram($a, $b);
                }
                else{
                    echo '<div class="header"> <h1>Welcome to my first PHP app</div>';
                }
                
            ?>
        </div>
    </body>
</html>
