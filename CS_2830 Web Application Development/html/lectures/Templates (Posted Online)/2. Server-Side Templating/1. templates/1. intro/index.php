<?php
// Created by Professor Wergeles for CS2830 at the University of Missouri


	// read this article 
	// 		https://www.smashingmagazine.com/2011/10/getting-started-with-php-templating/

  require 'Template.php';

  $page = new Template();
  $page->name = 'Professor Wergeles';
  $result = $page->build('page.tmpl');

  print $result;
  
  
  $page2 = new Template();
  $page2->name = 'Templates make life easier';
  $result2 = $page2->build('page.tmpl');

  print $result2;
?>
