package cl.edutecno.facade;

import cl.edutecno.dao.ProductoDAO;
import cl.edutecno.dto.ProductoDTO;

public class Facade {
	
	public int registrarProducto(ProductoDTO productoDTO) {
		ProductoDAO dao = new ProductoDAO();
		return dao.save(productoDTO);
	}

	public int actualizarProducto(ProductoDTO productoDTO) {
		
		return 0;
	}
}
