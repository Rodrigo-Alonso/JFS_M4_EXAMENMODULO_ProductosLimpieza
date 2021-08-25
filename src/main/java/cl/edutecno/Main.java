package cl.edutecno;

import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.facade.Facade;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade facade = new Facade();
		
		ProductoDTO dto = new ProductoDTO();
		dto.setNombreProducto("Producto 3");
		dto.setPrecioProducto(3990);
		dto.setDescripcionProducto("Es el tercer producto registrado");
		dto.setIdCategoria(3);
		dto.setIdUsuario(1);
		
		System.out.println(facade.registrarProducto(dto));
		
		
	}

}
