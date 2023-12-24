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
	<!-- how to apply dynamic css start-->
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<!-- how to apply dynamic End-->

<!-- how to apply dynamic Js file start-->
<script type="/js/ jquery-3.6.4.min.js"></script>
<!-- how to apply dynamic JS end-->

<title>Success</title>
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
	<!-- how to apply dynamic IMAGE start-->
<%-- <img alt="my image" src="<c:url value="/resources/image/Screenshot (1).png" />"> --%>
 <!-- how to apply dynamic IMAGE end-->
	<br>
	<h2>
		<p class="fs-bold text-center">
			<b>All User Details</b>
		</p>
	</h2>
	<br>
	<br>
	<div class="container">
		<c:if test="${not empty msg}">
			<h5>${msg}</h5>
			<c:remove var="msg"/> 
		</c:if>
		<table id="example" class="table table-bordered table-striped"
			cellspacing="0" border="1" width="100%" style="display: none">
			<thead class="thead-dark table-bordered">
				<tr>
					<th scope="col">fullName</th>
					<th scope="col">email</th>
					<th scope="col">password</th>
					<th scope="col">check</th>
					<!-- <th scope="col">image</th> -->
					<th scope="col">action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${user}" var="employee">
					<tr class="item">
						<td><c:out value="${employee.fullName}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.password}" /></td>
						<td><c:out value="${employee.check}" /></td>
						<%-- 	<td><c:out value="${employee.image}" /></td> --%>
						<td><a href="useredit/${employee.id}"
							class="btn btn-sm btn-primary" />Edit</a> <a
							href="userdelete/${employee.id}" class="btn btn-sm btn-danger" />Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


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
	<script src="<c:url value="/resources/js/success.js" />"></script>
</body>
</html>