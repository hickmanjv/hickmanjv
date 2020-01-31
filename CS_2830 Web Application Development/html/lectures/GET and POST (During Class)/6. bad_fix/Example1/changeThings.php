<?php
// 	Created by Professor Wergeles for CS2830 at the University of Missouri


    // Now typing in this URL will not change anything
    // Example: changeThings.php?action=delete&id=75


    // Get Data
    $action = $_POST['action'];
    $recordToChange = $_POST['id'];

    // Delete
    if ($action == 'delete') {
        // Call a function to delete record from database
        deleteRecord($recordToChange);
    }
    else {
    	print "No record was deleted.";
    }

    function deleteRecord($id) {
        print "Record #$id was deleted.";
    }
?>

