package cl.edutecno;

import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.facade.Facade;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade facade = new Facade();

		ProductoDTO dto = new ProductoDTO();

		// Agregar nuevo producto
//		dto.setNombreProducto("Producto 1");
//		dto.setPrecioProducto(3990);
//		dto.setDescripcionProducto("Es el cuarto producto registrado");
//		dto.setIdCategoria(4);
//		dto.setIdUsuario(1);
//
//		System.out.println(facade.registrarProducto(dto));

		// Actualizar nuevo producto
//		dto.setNombreProducto("Producto 1");
//		dto.setPrecioProducto(3990);
//		dto.setDescripcionProducto("Es el primero producto actualizado");
//		dto.setIdCategoria(1);
//		dto.setIdUsuario(1);
//		dto.setIdProducto(1);
//
//		System.out.println(facade.actualizarProducto(dto));

		//Borrar elemento
//		dto.setIdProducto(3);
//
//		System.out.println(facade.borrarProducto(dto));
		
		//Obtener listado de elementos
		System.out.println(facade.listarProductos());
		
	}

}
