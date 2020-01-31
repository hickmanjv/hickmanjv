<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<head>
	<title>File Upload Example</title>
</head>
<body>
    <h1>File Upload Test</h1>
<?php
    // Require our Upload class
    require_once "Upload.php";

	$target_dir = "uploads/"; 

    try {
        // Call a static function to reorder the contents of the $_FILES array
        $files = Upload::reorderFilesArray('files');

        // Static methods allow us to call those methods without an object instance
        // For example, above we can call "reorderFilesArray()" without creating a new Upload object
        // A Scope Resolution Operator (the "::") allows us to call static methods

        // Reference
        // http://www.php.net/manual/en/language.oop5.static.php
        // http://www.php.net/manual/en/language.oop5.paamayim-nekudotayim.php
    } catch (UploadExceptionNoFile $e) {
        print "No file was uploaded.<br>\n";
    } 

    // Foreach through those contents
    $n = 0;
    foreach ($files as $file) {
        $n++;
        try {
            $upload = new Upload($file);
            $origFileName = $upload->getOrigFileName();
            $fileExt = $upload->getFileExt();
            $fileSize = $upload->getFileSize();
            $mimeType = $upload->getMimeType();

            print "Original File Name: $origFileName<br>\n";
            print "File Extension: $fileExt<br>\n";
            print "Mime Type: $mimeType<br>\n";
            print "File Size: $fileSize<br>\n";
			
			if(!is_dir($target_dir) && !mkdir($target_dir)){
				die("error creating folder $targer_dir"); 
			}


            // Files will be named based on their order
            $destFilePath = $target_dir. 'file' . $n . '.' . $fileExt;
            $upload->moveFile($destFilePath);

            if ($fileExt == 'jpg' || $fileExt == 'gif' || $fileExt == 'png') {
                print "<p><img src='$destFilePath' alt='uploaded image'></p>\n";
            }

            print "<hr>\n";

        } catch (UploadExceptionNoFile $e) {
            print "No file was uploaded.<br>\n";
        } catch (UploadException $e) {
            $code = $e->getCode();
            $message = $e->getMessage();
            print "Error: $message (code=$code)<br>\n";
        }
    }

?>
</body>
</html>
