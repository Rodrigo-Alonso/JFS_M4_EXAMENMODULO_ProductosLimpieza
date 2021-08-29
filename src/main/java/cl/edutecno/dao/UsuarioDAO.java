package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cl.edutecno.conexion.AdministradorConexion;
import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.dto.UsuarioDTO;

public class UsuarioDAO extends AdministradorConexion {

	public UsuarioDAO() {
		Connection conn = generaConexion();
	}

	public int save(UsuarioDTO usuarioDTO) {

		int status = 0;
		try {

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO USUARIO (NOMBRE_USUARIO, CORREO_USUARIO, TELEFONO_USUARIO, PASS_USUARIO) "
					+ "VALUES(?,?,?,?)");

			ps.setString(1, usuarioDTO.getNombreUsuario());
			ps.setString(2, usuarioDTO.getCorreoUsuario());
			ps.setString(3, usuarioDTO.getTelefonoUsuario());
			ps.setString(4, usuarioDTO.getPassUsuario());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public int update(UsuarioDTO usuarioDTO) {

		int status = 0;

		try {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE USUARIO SET PASS_USUARIO=? WHERE CORREO_USUARIO=?");

			ps.setString(1, usuarioDTO.getPassUsuario());
			ps.setString(2, usuarioDTO.getCorreoUsuario());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}
