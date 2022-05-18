<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>iSINT - Home</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" type="text/css"
	href="/bootstrap/css/bootstrap.css">
<!-- Font Awesome CSS -->
<link rel="stylesheet" type="text/css" href="/fontawesome/css/all.css">
<!-- Our Custom CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/style-home.css">
<!--  Our JavaScript File -->
<script type="text/javascript" src="/js/function.js"></script>
<%@ include file="/includeFile/favIcon.txt" %>
</head>
<body>

	<%@ include file="/includeFile/navBar.txt" %> 
	<div class="wrapper">	
		<!-- Page Content Holder -->
		<div id="content">
			<div class="container">
				<div class="row">
					<div class="col-md-4 text-center">
						<a href="/RichiediCercaArticolo">
							<div class="service">
								<i class="fa fa-clipboard-list fa-2x" area-hidden="true"></i>
								<h4>Inventario</h4>
							</div>
						</a>
					</div>
					<div class="col-md-4 text-center">
						<a href="/Rilevazioni">
							<div class="service">
								<i class="fa fa-boxes fa-2x" area-hidden="true"></i>
								<h4>Lista Rilevazioni</h4>
							</div>
						</a>
					</div>
					<div class="col-md-4 text-center">
						<a href="/Estrai">
							<div class="service">
								<i class="fa fa-chart-bar fa-2x" area-hidden="true"></i>
								<h4>Estrai</h4>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/includeFile/footer.txt" %>

	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
		
	<!--  <script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
				$(this).toggleClass('active');
			});
		});
	</script>-->
</body>
</html>





