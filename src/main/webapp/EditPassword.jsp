<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@100;300;400;700&display=swap"
	rel="stylesheet">

<!--FontAwesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<title>Edit Password</title>
</head>
<body>

	<!--FORMULARIO EDIT PASSWORD-->
	<section class="container pt-5 mt-5">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form action="editPassword" method='POST'>
					<div class="card mb-3 shadow">
						<div id="image" class="p-4">
							<img src="${pageContext.request.contextPath}/assets/img/logo.png"
								class="card-img-top mx-auto d-block" alt="logo"
								style="width: 250px; height: auto;">
						</div>
						<div class="card-body px-4">
							<div>
								<h2 class="pb-2">
									<c:out value="Crea una nueva clave para el usuario ${name}" />
								</h2>
							</div>
							<div class="mb-3">
								<input type="hidden" name="email" value="${param.email}">
								<label for="text" class="form-label">Usuario</label> <input
									type="email" class="form-control" name="email2"
									value="${email}" disabled />
								<div id="userHelp" class="form-text">No compartas tu
									usuario con nadie</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Nueva
									Password</label> <input type="password" class="form-control"
									id="password" placeholder="*********" name="password" required>
							</div>
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-success" type="button">Ingresar</button>
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
</html>