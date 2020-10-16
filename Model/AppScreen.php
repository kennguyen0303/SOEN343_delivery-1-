<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <title>Smart Home Simulator</title>
    <!-- Custom styles for this template -->
    <link href="style.css" rel="stylesheet">
</head>
<body>
	<div class = "layout-container">
		<div class = "sidebar">
			<?php include 'dashboard.html';?>
		</div>
		<div class = "tab-items">
			<?php include 'tabItems.html';?>
		</div>
		<div class = "house-diagram">
			<?php include 'index.html';?>
				
			</div>
		
		<div class = "console">Console Here</div>
	</div>
</body>
</html>