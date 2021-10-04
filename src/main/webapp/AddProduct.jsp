<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.edutecno.dto.ProductoDTO"%>
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



<title>Add Product</title>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><img
				src="${pageContext.request.contextPath}/assets/img/logo.png"
				class="card-img-top mx-auto d-block" alt="logo"
				style="width: 40px; height: auto;"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="listarProductos">Home</a></li>
				</ul>
				<span class="navbar-text"><c:out value="Usuario: ${user}" /></span>
				<ul class="d-flex mb-0">
					<li class="navbar-nav me-auto mb-2 mb-lg-0"><a
						class="nav-link text-end" href="Login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!--TITULO-->
	<div class="my-5 text-center">
		<h1>Agregar Nuevo Producto</h1>
	</div>

	<!-- CARD -->
	<section class="container pt-5 mt-5">
		<div class="row">
			<div class="col-lg-3 md-1"></div>
			<div class="col-lg-6 md-10">
				<div class="card mb-3 shadow" style="max-width: 540px;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${pageContext.request.contextPath}/assets/img/logo.png"
								class="img-fluid rounded-start mt-5 pt-4" alt="imgAddProduct">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<form action="addProduct" method="POST">
									<div>
										<h5 class="card-title">Ingrese los siguientes datos</h5>
										<div class="input-group mb-3">
											<span class="input-group-text" id="basic-addon1">Nombre</span>
											<input type="text" class="form-control"
												placeholder="Nombre Producto" name="name">
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="basic-addon1">Precio</span>
											<input type="number" class="form-control"
												placeholder="$1.990" name="price">
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="basic-addon1">Descripcion</span>
											<textarea class="form-control"
												placeholder="Descripcion del producto..." name="description"></textarea>
										</div>
										<div class="mb-3">
											<div class="input-group mb-3">
												<label class="input-group-text" for="inputGroupSelect01">Seleccione
													Categoria</label> <select class="form-select" name="category">
													<c:forEach var="var" items="${listaCategorias}">
														<option value="${var.idCategoria}">${var.nombreCategoria}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
										<a type="button" class="btn btn-light"
											href="listarProductos">Cancelar</a>
										<button type="submit" class="btn btn-dark">Guardar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 md-1"></div>
		</div>
	</section>


	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>