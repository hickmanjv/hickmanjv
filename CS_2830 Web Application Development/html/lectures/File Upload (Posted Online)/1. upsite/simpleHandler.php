<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

	$target_dir = "uploads/"; 

    // Foreach through the $_FILES array
    foreach ($_FILES as $inputName => $fileArray) {
		print "$inputName = $fileArray<br>\n";
		
		foreach ($fileArray as $key => $value) {
			print "- $key = $value<br>\n";
		}
	}
	
	if(!is_dir($target_dir) && !mkdir($target_dir)){
		die("error creating folder $targer_dir"); 
	}

    // Once the file is uploaded, we have to move it out of temporary storage
    // http://php.net/manual/en/function.move-uploaded-file.php
    $result = move_uploaded_file($_FILES['file1']['tmp_name'], $target_dir . 'upload.png');

	if($result){
		echo "File was moved successfully!"; 
	}
	else {
		echo "File no no"; 
	}	
?>