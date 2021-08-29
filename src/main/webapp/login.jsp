<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS v5.1.0-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Login</title>
</head>

<body>

	<!--FORMULARIO LOGIN-->
	<section class="container-fluid pt-5">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form action="procesaLogin" method='POST'>
					<div class="card mb-3 shadow">
						<div id="image" class="p-5">
							<img
								src="${pageContext.request.contextPath}/assets/img/logo.png"
								class="card-img-top" alt="logo">
						</div>
						<div class="card-body">

							<div class="mb-3">
								<label for="text" class="form-label">Usuario</label> <input
									type="text" class="form-control" id="user"
									placeholder="Username" name="user" required>
								<div id="userHelp" class="form-text">No compartas tu
									usuario con nadie</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" id="password"
									placeholder="*********" name="pass" required>
							</div>
							<div class="d-grid gap-2 d-md-flex justify-content-md-end">
								<button type="submit" class="btn-success btn-sm px-3">Enviar</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</section>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>