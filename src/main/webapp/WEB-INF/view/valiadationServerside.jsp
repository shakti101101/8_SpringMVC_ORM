<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script type="/js/ jquery-3.6.4.min.js"></script>

</head>
<body>
	<div class="container p-4">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<p class="name"></p>
					<div class="card-header text-center fs-3">Login Here</div>

					<div class="card-body">
						<form action="serversidevalidation" method="post">
							<c:forEach items="${logindata}" var="ser">

								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label is-invalid" >User
										Name </label> <input type="text" class="form-control" name="username"
										id="username">
									<p>
										
									</p>
									<div class="invalid-feedback"><c:out value="${ser.username}" />
									</div>

								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Password</label>
									<input type="password" class="form-control" name="password"
										id="password">
								</div>

								<!-- <div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input type="text" class="form-control" name="img"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div> -->
							<button type="submit" class="btn btn-primary col-md-12">Login</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							</c:forEach>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<%--  <script src="<c:url value="/resources/js/register.js" />"></script> --%>
</body>
</html>