<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri

    // HTTPS redirect
    if ($_SERVER['HTTPS'] !== 'on') {
		$redirectURL = 'https://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
		header("Location: $redirectURL");
		exit;
	}

	$username = empty($_COOKIE['username']) ? '' : $_COOKIE['username'];
	if (!$username) {
		header("Location: login.php");
		exit;
	}

    // If the user is authorized to view this content, we will display it.
    // But before we do, we will set these headers to prevent caching.
    header("Cache-Control: no-store, no-cache, must-revalidate, pre-check=0, post-check=0, max-age=0, s-maxage=0");
    header("Pragma:no-cache");
    header("Expires: 0");

    // Browsers cache content by default. It makes for more efficient,
    // faster loading web apps, but it's not always the desired behavior.
    // This is especially true when the conent contains sensitive information.
?>
<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<html>
<head>
	<title>Page 2</title>
    <link href="app.css" rel="stylesheet" type="text/css">
    <link href="../jquery-ui-1.11.4.custom/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <script src="../jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
    <script src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
</head>
<body>
    <div class="ui-widget pageWidget">
        <h1 class="ui-widget-header">Page 2</h1>
        <div class="ui-widget-content">
            <p>This is also a page containing protected content.</p>
            <p>You must be logged in to view this page.</p>
            <p><a href='page1.php'>Go to page 1.</a></p>
            <p><a href='logout.php'>Logout</a></p>
        </div>
    </div>
</body>
</html>
