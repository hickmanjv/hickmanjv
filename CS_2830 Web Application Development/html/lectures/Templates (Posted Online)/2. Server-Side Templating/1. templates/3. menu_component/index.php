<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

// Require the MenuComponent class
require_once("MenuComponent.php");

// Create an array of menu items and their links
$menuItems = array();
$menuItems[] = array('label' => 'Home', 'link' => 'home.php');
$menuItems[] = array('label' => 'People', 'link' => 'people.php');
$menuItems[] = array('label' => 'Activities', 'link' => 'activities.php');
$menuItems[] = array('label' => 'Contacts', 'link' => 'contacts.php');
$menuItems[] = array('label' => 'Help', 'link' => 'help.php');
$menuItems[] = array('label' => 'Login', 'link' => 'login.php');

// Specify the currently selected tab
$currentPage = 'Contacts';

// Create a new MenuComponent object (pass it the menu items and the currently selected one)
$menu = new MenuComponent($menuItems, $currentPage);
// Call MenuComponent's 'generate()' method
$result = $menu->generate();

// generate() returns an array containing a path to a CSS file and the menu's html
$menuCSSFile = $result['cssFile'];
$menuHTML = $result['html'];
?>
<!DOCTYPE html>
<html>
<head>
<title>Menu Component Test</title>
<link rel="stylesheet" href="<?php print $menuCSSFile; ?>" type="text/css">
</head>
<body>
<?php print $menuHTML; ?>
</body>
</html>