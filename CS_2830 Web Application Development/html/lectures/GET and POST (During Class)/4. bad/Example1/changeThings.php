<?php
// 	Created by Professor Wergeles for CS2830 at the University of Missouri


    // URLs should NOT change or delete data
    // Example: changeThings.php?action=delete&id=75


    // Get Data
    $action = $_GET['action'];
    $recordToChange = $_GET['id'];

    // Delete
    if ($action == 'delete') {
        // Call a function to delete record from database
        deleteRecord($recordToChange);
    }

    function deleteRecord($id) {
        print "Record #$id was deleted.";
    }
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Content Management System</title>
	</head>
	<body>
        <ul>
            <li><a href="changeThings.php?action=delete&id=1">Delete record #1</a></li>
            <li><a href="changeThings.php?action=delete&id=2">Delete record #2</a></li>
            <li><a href="changeThings.php?action=delete&id=3">Delete record #3</a></li>
        </ul>
	</body>
</html>
