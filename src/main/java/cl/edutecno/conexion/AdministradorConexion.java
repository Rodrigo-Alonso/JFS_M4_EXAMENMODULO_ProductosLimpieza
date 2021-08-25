package cl.edutecno.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdministradorConexion {

	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;

	protected Connection generaConexion() {
		String usr = "";
		String pwd = "";
		String driver = "org.sqlite.JDBC";
		String url =
				"jdbc:sqlite:/home/verdata/eclipse-workspace/M4_EXAMENFINAL_productosLimpieza/productosLimpieza_DDBB";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Conexion Establecida");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	protected Connection generaPoolConexion() {
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds =
						(DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionSQLITE_productosLimpiezaDDBB");
				try {
					conn = ds.getConnection();
					System.out.println("CREACION DE CONEXION CON GetConnection");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return conn;
		} else {
			System.out.println("Ya hay una conexion");
			return conn;
		}
		
	}
}
