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
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="Home.jsp">Home</a>
					<a class="nav-link" href="ListProduct.jsp">Listar Producto</a> <a
						class="nav-link" href="AddProduct.jsp">Ingresar Productos</a> <a
						class="nav-link" href="EditProduct.jsp">Editar Productos</a>
				</div>
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
					<button type="button" class="btn btn-success me-md-2"
						data-bs-toggle="modal" data-bs-target="#addModal">
						<i class="fas fa-plus"> Agregar Producto</i>
					</button>
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
							href="eliminarProducto?idProducto=${var.getIdProducto()}"
							class="btn btn-danger btn-sm mx-1"><i
								class="fas fa-trash-alt fa-1x mx-1"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
								<h5 class="modal-title text-center ps-3 mb-3" id="title">Agregar
									Producto</h5>
							</div>
							<div
								class="col-sm-2 d-grid gap-2 d-md-flex justify-content-md-end">
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<img src="/assets/img/libro.png"
									class="card-img-top mx-auto d-block" alt="libro"
									style="width: 250px; height: auto;">
							</div>
						</div>
					</div>
				</div>

				<div class="modal-body">
					<form action="addLibro" modelAttribute="libro" method="POST">
						<div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Titulo</span> <input
									type="text" class="form-control" placeholder="Titulo Libro"
									name="titulo" id="titulo">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Autor</span> <input
									type="text" class="form-control" placeholder="Autor Libro"
									name="autor" id="autor">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Año</span> <input
									type="text" class="form-control" placeholder="2021" name="anio"
									id="anio">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Imprenta</span>
								<input type="text" class="form-control"
									placeholder="Imprenta S.A." name="imprenta" id="imprenta">
							</div>
							<div class="mb-3">
								<div class="input-group mb-3">
									<label class="input-group-text" for="inputGroupSelect01">Seleccione
										Disponibilidad</label> <select class="form-select" name="disponible"
										id="disponible">
										<option value="1">Disponible</option>
										<option value="2">No Disponible</option>
									</select>
								</div>
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


	<!-- Opciones -->
	<!--  
	<section class="container my-5">
		<div class="py-5">
			<h1 class="text-center">Seleccione una opcion que desea realizar</h1>
		</div>
		<div class="row">
			<div class="col px-0 py-4">
				<div class="card text-center shadow mx-0" style="width: 18rem;">
					<i class="fas fa-clipboard-list card-img-top fa-5x p-3 text-muted"></i>
					<div class="card-body">
						<h5 class="card-title">Listar Productos</h5>
						<p class="card-text">Liste todos los productos que estan disponibles</p>
						<div class="d-grid gap-2">
							<button type="submit" class="btn btn-success" type="button">Ingresar</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col px-0 py-4">
				<div class="card text-center shadow mx-0" style="width: 18rem;">
					<i class="fas fa-plus card-img-top fa-5x p-3 text-muted"></i>
					<div class="card-body">
						<h5 class="card-title">Ingresar Productos</h5>
						<p class="card-text">Ingrese un nuevo producto al listado</p>
						<div class="d-grid gap-2">
							<button type="submit" class="btn btn-success" type="button">Ingresar</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col px-0 py-4">
				<div class="card text-center shadow mx-0" style="width: 18rem;">
					<i class="far fa-edit card-img-top fa-5x p-3 text-muted"></i>
					<div class="card-body">
						<h5 class="card-title">Editar/Eliminar Producto</h5>
						<p class="card-text">Edite o elimine alguno de los productos que esten en el listado</p>
						<div class="d-grid gap-2">
							<button type="submit" class="btn btn-success" type="button">Ingresar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	-->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>