<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-5.0.2-dist/css/bootstrap.min.css"/>">

</head>
<body>
	<h1></h1>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center fs-3">Dispute Report</div>

					<div class="card-body">
						<form action="reportDate" method="post">

							<div class="row">
								<div class="col-md-6">

									<label for="exampleInputEmail1" class="form-label">
										From Date </label> <input type="date" class="form-control"
										name="fromdate" id="fromdate" aria-describedby="fromdate">

								</div>


								<div class="col-md-6">

									<label for="exampleInputEmail1" class="form-label"> To
										date </label> <input type="date" class="form-control" name="todate"
										id="todate" aria-describedby="todate">

								</div>

							</div>
                              <div class="row p-4" ></div>
							<button type="submit" class="btn btn-primary col-md-12">Register</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
<script>
    $(document).ready(function(){
      var date_input=$('input[name="date"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>
<!--  jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	<script
		src="<c:url value="/resources/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js" />"></script>
</body>
</html>