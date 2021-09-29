package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cl.edutecno.conexion.AdministradorConexion;
import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.dto.UsuarioDTO;

public class UsuarioDAO extends AdministradorConexion {

	public UsuarioDAO() {
		Connection conn = generaPoolConexion();
	}

	public static int save(UsuarioDTO usuarioDTO) {

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

	public static int update(UsuarioDTO usuarioDTO) {

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
	
	public static UsuarioDTO getRecordByEmail(String email) {

		UsuarioDTO usuarioDTO = null;

		try {

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM USUARIO WHERE CORREO_USUARIO=?");

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				usuarioDTO = new UsuarioDTO();
				usuarioDTO.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuarioDTO.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
				usuarioDTO.setCorreoUsuario(rs.getString("CORREO_USUARIO"));
				usuarioDTO.setTelefonoUsuario(rs.getString("TELEFONO_USUARIO"));
				usuarioDTO.setPassUsuario(rs.getString("PASS_USUARIO"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarioDTO;
	}
	
}
