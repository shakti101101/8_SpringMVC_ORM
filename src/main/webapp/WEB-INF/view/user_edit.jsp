<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<script type="/js/ jquery-3.6.4.min.js"></script>

<title>user_Edit</title>
<link
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
<link
	href="https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css">
<link
	href="https://cdn.datatables.net/select/1.6.2/css/select.dataTables.min.css">

<!-- dataTable links start-->
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.2.1/js/dataTables.buttons.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
<script
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.html5.min.js"></script>

<link
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://cdn.datatables.net/buttons/1.2.1/css/buttons.dataTables.min.css"
	rel="stylesheet" type="text/css">
<!-- dataTable links End-->

</head>
<body>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center fs-3">User Update </div>
					
					<div class="card-body">
						<c:forEach items="${usere}" var="emp">
							<form action="${pageContext.request.contextPath}/updateUser"
								method="post">

								<div class="mb-3">
									<label for="fullName" class="form-label"> </label> <input
										type="hidden" class="form-control" name="id"
										value="${emp.id}" id="id">

								</div>

								<div class="mb-3">
									<label for="fullName" class="form-label">Full Name </label> <input
										type="text" class="form-control" name="fullName" id="fullName" value="${emp.fullName}">

								</div>
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email
										address</label> <input type="email" class="form-control" name="email"
										id="exampleInputEmail1"  value="${emp.email}">

								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Password</label>
									<input type="password" class="form-control" name="password"
										id="exampleInputPassword1" value="${emp.password}">
								</div>

								<!-- <div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input type="text" class="form-control" name="img"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div> -->
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input" name="check"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">Check me out</label>
								</div>
								<button type="submit" class="btn btn-primary col-md-12">update</button>
							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- dataTable links start-->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js"></script>
	<script
		src="https://cdn.datatables.net/select/1.6.2/js/dataTables.select.min.js"></script>
	<!-- dataTable links end-->



	<script src="<c:url value="/resources/js/user_edit.js" />"></script>
</body>
</html>