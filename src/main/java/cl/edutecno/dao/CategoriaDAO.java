package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.edutecno.conexion.AdministradorConexion;
import cl.edutecno.dto.CategoriaDTO;

public class CategoriaDAO extends AdministradorConexion {

	public CategoriaDAO() {
		Connection conn = generaPoolConexion();
	}

	public List<CategoriaDTO> list() {

		List<CategoriaDTO> listaCategorias = new ArrayList<CategoriaDTO>();

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CATEGORIA");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoriaDTO dto = new CategoriaDTO();
				dto.setIdCategoria(rs.getInt("ID_CATEGORIA"));
				dto.setNombreCategoria(rs.getString("NOMBRE_CATEGORIA"));
				
				listaCategorias.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaCategorias;

	}

}
