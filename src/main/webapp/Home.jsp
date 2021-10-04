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



<title>Home</title>
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
		<h1>Productos de Limpieza</h1>
	</div>

	<!-- BOTON AGREGAR -->
	<section class="container">
		<div class="row">
			<div class="col">
				<div class="">
					<a type="button" class="btn btn-success me-md-2"
						href="processProduct">
						<i class="fas fa-plus"> Agregar Producto</i>
					</a>
				</div>
			</div>
		</div>
	</section>

	<!--TABLE-->
	<section class="container my-4">
		<table class="table" id="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Precio</th>
					<th scope="col">Descripcion</th>
					<th scope="col">Categoria</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaProductos}" var="var">
					<tr>
						<td>${var.getNombreProducto()}</td>
						<td>$${var.getPrecioProducto()}</td>
						<td>${var.getDescripcionProducto()}</td>
						<c:forEach items="${listaCategorias}" var="var2">
							<c:if test="${var2.getIdCategoria() == var.getIdCategoria()}">
								<td>${var2.getNombreCategoria()}</td>
							</c:if>
						</c:forEach>
						<td><a
							href="editarProducto?idProducto=${var.getIdProducto()}"
							class="btn btn-primary btn-sm mx-2"><i
								class="fas fa-edit fa-1x mx-1"></i></a> <a
							href="deleteProduct?idProducto=${var.getIdProducto()}"
							class="btn btn-danger btn-sm mx-1"><i
								class="fas fa-trash-alt fa-1x mx-1"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>