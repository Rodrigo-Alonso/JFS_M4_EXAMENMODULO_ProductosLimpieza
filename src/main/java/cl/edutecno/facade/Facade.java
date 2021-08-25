package cl.edutecno.facade;

import java.util.List;

import cl.edutecno.dao.ProductoDAO;
import cl.edutecno.dto.ProductoDTO;

public class Facade {
	
	public int registrarProducto(ProductoDTO productoDTO) {
		ProductoDAO dao = new ProductoDAO();
		return dao.save(productoDTO);
	}

	public int actualizarProducto(ProductoDTO productoDTO) {
		
		ProductoDAO dao = new ProductoDAO();
		return dao.update(productoDTO);
	}
	
	public int borrarProducto(ProductoDTO productoDTO) {
		ProductoDAO dao = new ProductoDAO();
		return dao.delete(productoDTO);
	}
	
	public List<ProductoDTO> listarProductos() {
		ProductoDAO dao = new ProductoDAO();
		return dao.list();
	}
	
}
