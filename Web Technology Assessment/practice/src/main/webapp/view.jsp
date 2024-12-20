<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.usermodel"%>
<%@page import="Dao.Userdao"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<h1>List of Employees</h1>
	<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<%--  <%
	usermodel s = null;
	if (session.getAttribute("data") != null) {
		s = (usermodel)session.getAttribute("data");
	} else {
		response.sendRedirect("INDEX.jsp");
	}
	%>
    <h4>
		EMPID :
		<%=s.getId()%></h4>

	<h4>
		First Name :
		<%=s.getFname()%></h4>
	<h4>
		Last Name :
		<%=s.getLname()%></h4>
	<h4>
		Email :
		<%=s.getEmail()%></h4>
	<h4>
		Mobile :
		<%=s.getMobile()%></h4> --%>

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">EMPID</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile</th>
					<th colspan="2" scope="col">Action</th>

				</tr>
			</thead>
			<tbody>
				<%
				List<usermodel> list = Userdao.getALLEmployees();
				%>
				<%
				for (usermodel s1 : list) {
				%>
				<tr>
					<th scope="row"><%=s1.getId()%></th>
					<td><%=s1.getFname()%></td>
					<td><%=s1.getLname()%></td>
					<td><%=s1.getEmail()%></td>
					<td><%=s1.getMobile()%></td>

					 <td>
						<form  action="usercontroller" method="post">
							<input type="hidden" name="id" value="<%=s1.getId()%>"> 
							<input class="btn btn-primary" type="submit" name="action" value="edit">
							
						
						
							<input type="hidden" name="id" value="<%=s1.getId()%>"> 
							<input class=" btn btn-danger" type="submit" name="action" value="delete">
						</form>
					</td>

					<%-- <td><a 
						href="usercontroller?action=edit&id=<%=s1.getId()%>"><i class="fa fa-pencil me-4" aria-hidden="true"></i></a><a
						
						href="usercontroller?action=delete&id=<%=s1.getId()%>"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
					</td> --%>
					<!-- <td><a href="">Delete</a></td> -->
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>


	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>


