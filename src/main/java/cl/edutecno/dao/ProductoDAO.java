package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cl.edutecno.conexion.AdministradorConexion;
import cl.edutecno.dto.ProductoDTO;

public class ProductoDAO extends AdministradorConexion {

	// Constructor
	public ProductoDAO() {
		Connection conn = generaPoolConexion();
	}

	public int save(ProductoDTO productoDTO) {

		int status = 0;
		try {

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO PRODUCTO (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, DESCRIPCION_PRODUCTO, ID_CATEGORIA, "
							+ "ID_USUARIO) VALUES(?,?,?,?,?)");

			ps.setString(1, productoDTO.getNombreProducto());
			ps.setInt(2, productoDTO.getPrecioProducto());
			ps.setString(3, productoDTO.getDescripcionProducto());
			ps.setInt(4, productoDTO.getIdCategoria());
			ps.setInt(5, productoDTO.getIdUsuario());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public int update(ProductoDTO productoDTO) {
		
		int status = 0;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE PRODUCTO SET NOMBRE_PRODUCTO=?, PRECIO_PRODUCTO=?, DESCRIPCION_PRODUCTO=?, ID_CATEGORIA=?, ID_USUARIO=?");
			//ps.set
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
