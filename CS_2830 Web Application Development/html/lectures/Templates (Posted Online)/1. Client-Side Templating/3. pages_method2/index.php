<!DOCTYPE html>
<!-- Created by Professor Wergeles for CS2830 at the University of Missouri -->
<html>
<head>
	<title>Content Navigator</title>
	<link rel="stylesheet" href="app.css" type="text/css">
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(function() {
			$.get("appData.php", function(data) {
				$("#wrapper h1").html(data.appTitle);

				// Method 2: using forEach
				// JavaScript forEach(): https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach?v=example
				// jQuery each(): http://api.jquery.com/jquery.each/
				data.posts.forEach(function(post){
					var $li = $("<li>");
					$li
						.html(post.title)
						.click(function() {
							$.get("appData.php", {"content": post.id}, function(data) {
									$("#display").empty();
									postContent(data);
							});
						});
						$("#wrapper ul").append($li);
				});

				postContent(data.posts[0]);

			});

			function postContent(data) {
				var $h2 = $("<h2>");
				var $div = $("<div>");
				var $p = $("<p>");

				$h2.html(data.title);
				$div.addClass("imgPlaceholder " + data.color);
				$p.html(data.content);
				$("#display")
					.append($h2)
					.append($div)
					.append($p);
			}
		});
	</script>
</head>
<body>
	<div id="wrapper" class="group">
		<h1></h1>
		<hr>
		<ul id="menu"></ul>
		<div id="display"></div>
	</div>
</body>
</html>
