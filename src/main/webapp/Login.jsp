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

<title>Login</title>
</head>

<body>

	<!--FORMULARIO LOGIN-->
	<section class="container pt-5 mt-5">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form action="procesaLogin" method='POST'>
					<div class="card mb-3 shadow">
						<div id="image" class="p-4">
							<img src="${pageContext.request.contextPath}/assets/img/logo.png"
								class="card-img-top mx-auto d-block" alt="logo"
								style="width: 250px; height: auto;">
						</div>
						<div class="card-body px-4">
							<div class="mb-3">
								<label for="text" class="form-label">Usuario</label> <input
									type="email" class="form-control" id="user"
									placeholder="user@mail.com" name="email" required>
								<div id="userHelp" class="form-text">No compartas tu
									usuario con nadie</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" id="password"
									placeholder="*********" name="pass" required>
							</div>
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-success" type="button">Ingresar</button>
							</div>
							<div class="container pt-5 px-0">
								<div class="row">
									<div class="col text-start">
										<button type="button" class="btn" data-bs-toggle="modal"
											data-bs-target="#findModal">>Olvido de Clave</button>
									</div>
									<div class="col text-end">
										<button type="button" class="btn" data-bs-toggle="modal"
											data-bs-target="#addModal">>Agregar Usuario</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</section>

	<!-- MODAL ADD -->
	<div class="modal fade" id="addModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-10 ps-5">
								<h5 class="modal-title text-center ps-3 mt-3" id="title">Agregar
									Usuario</h5>
							</div>
							<div
								class="col-sm-2 d-grid gap-2 d-md-flex justify-content-md-end">
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-body">
					<form action="addUser" method="POST">
						<div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Nombre</span> <input
									type="text" class="form-control" placeholder="Homero Simpson"
									name="name">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Correo</span> <input
									type="email" class="form-control" placeholder="homero@mail.com"
									name="email">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Telefono</span>
								<input type="text" class="form-control" placeholder="+569"
									name="phone">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Password</span>
								<input type="password" class="form-control"
									placeholder="**********" name="password">
							</div>
						</div>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
							<button type="button" class="btn btn-light"
								data-bs-dismiss="modal">Cancelar</button>
							<button type="submit" class="btn btn-dark">Guardar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- MODAL FIND -->
	<div class="modal fade" id="findModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-10 ps-5">
								<h5 class="modal-title text-center ps-3 mt-3" id="title">Buscar
									Usuario</h5>
							</div>
							<div
								class="col-sm-2 d-grid gap-2 d-md-flex justify-content-md-end">
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-body">
					<form action="findUser" method="POST">
						<div>
							<div>
								<h4 class="text-center py-3">Ingrese correo del usuario a buscar</h4>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Correo</span> <input
									type="email" class="form-control" placeholder="homero@mail.com"
									name="email">
							</div>
						</div>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
							<button type="button" class="btn btn-light"
								data-bs-dismiss="modal">Cancelar</button>
							<button type="submit" class="btn btn-dark">Buscar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>