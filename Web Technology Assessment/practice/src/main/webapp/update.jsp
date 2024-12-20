<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.usermodel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>

	<%-- <%scriplets %> --%>
	<%
	String msg = (String) request.getAttribute("msg");
	%>
	<%
	if (msg != null) {
	%>
	<%
	out.print(msg);
	%>
	<%
	}
	%>
	<%
	usermodel s = (usermodel) request.getAttribute("data");
	%>

	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						
						<h4 class="card-title mt-2">Update Employee</h4>
					</header>
					<article class="card-body">
					
					<form action="usercontroller" method="post">
					<input type="hidden" name="id" value="<%=s.getId()%>">
						<div class="">
							<div class="form-group">
								<label>First name </label> 
								<input type="text" name="fname" value="<%=s.getFname()%>">

							</div>
							<!-- form-group end.// -->
							<div class="form-group">
								<label>Last name</label> 
								<input type="text" name="lname" value="<%=s.getLname()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<label>Email</label> 
							<input type="email" name="email" value="<%=s.getEmail()%>">

						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Mobile</label> 
							<input type="text" name="MOBILE" value="<%=s.getMobile()%>">
							

						</div>
						<!-- form-group end.// -->
						<div class="form-group">
						<input  type="submit" name="action" value="update" class="btn btn-primary btn-block">
							
						</div>

					</form>
					
					</article>
					<!-- form-group// -->
				</div>
				<!-- card.// -->
			</div>
			<!-- col.//-->

		</div>
		<!-- row.//-->


	</div>
</body>
</html>