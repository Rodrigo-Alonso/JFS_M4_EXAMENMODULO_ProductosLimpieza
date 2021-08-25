package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.edutecno.conexion.AdministradorConexion;
import cl.edutecno.dto.ProductoDTO;

public class ProductoDAO extends AdministradorConexion {

	// Constructor
	public ProductoDAO() {
		Connection conn = generaConexion();
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

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE PRODUCTO SET NOMBRE_PRODUCTO=?, PRECIO_PRODUCTO=?, DESCRIPCION_PRODUCTO=?, ID_CATEGORIA=?, "
							+ "ID_USUARIO=? WHERE ID_PRODUCTO=?");
			
			ps.setString(1, productoDTO.getNombreProducto());
			ps.setInt(2, productoDTO.getPrecioProducto());
			ps.setString(3, productoDTO.getDescripcionProducto());
			ps.setInt(4, productoDTO.getIdCategoria());
			ps.setInt(5, productoDTO.getIdUsuario());
			ps.setInt(6, productoDTO.getIdProducto());

			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int delete(ProductoDTO productoDTO) {
		
		int status = 0;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO=?");
			
			ps.setInt(1, productoDTO.getIdProducto());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public List<ProductoDTO> list() {
		
		List<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PRODUCTO");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductoDTO dto =  new ProductoDTO();
				dto.setIdProducto(rs.getInt("ID_PRODUCTO"));
				dto.setNombreProducto(rs.getString("NOMBRE_PRODUCTO"));
				dto.setPrecioProducto(rs.getInt("PRECIO_PRODUCTO"));
				dto.setDescripcionProducto(rs.getString("DESCRIPCION_PRODUCTO"));
				dto.setIdCategoria(rs.getInt("ID_CATEGORIA"));
				dto.setIdUsuario(rs.getInt("ID_USUARIO"));
				
				listaProductos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProductos;
		
	}
	
	

}
