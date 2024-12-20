<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<div class="container">

	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header">
					<a href="view.jsp" class="float-right btn btn-outline-primary mt-1">View
						Employee</a>
					<h4 class="card-title mt-2">Add Employee</h4>
				</header>
				<article class="card-body">
					<form action="usercontroller" method="post">
						<div class="form-row">
							<div class="col form-group">
								<label>First name </label> <input type="text" name="fname"
									class="form-control" placeholder="">

							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Last name</label> <input type="text" name="lname"
									class="form-control" placeholder=" ">
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<label>Email</label> <input type="email" name="email"
								class="form-control" placeholder="">

						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Mobile</label> <input type="mobile" name="mobile"
								class="form-control" placeholder="">

						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Address</label> <input type="address" name="address"
								class="form-control" placeholder="">

						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Gender</label> <label class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
								value="male"> <span class="form-check-label">
									Male </span>
							</label> <label class="form-check form-check-inline"> <input
								class="form-check-input" type="radio" name="gender"
								value="female"> <span class="form-check-label">
									Female</span>
							</label>
						</div>
						<!-- form-group end.// -->

						<div class="form-group">
							<label>Password</label> <input class="form-control"
								type="password" name="pass">
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Confirm password</label> <input class="form-control"
								type="password" name="cpass">
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<button type="Submit" value="Submit" name="action"
								class="btn btn-primary btn-block">Submit</button>
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
<!--container end.//-->


