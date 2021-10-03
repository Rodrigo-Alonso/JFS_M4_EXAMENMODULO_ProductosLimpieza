package cl.edutecno.dto;

public class UsuarioDTO {
	
	private int idUsuario;
	private String nombreUsuario;
	private String correoUsuario;
	private String telefonoUsuario;
	private String passUsuario;
	
	//G&S
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}
	
	//toString
	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", correoUsuario="
				+ correoUsuario + ", telefonoUsuario=" + telefonoUsuario + ", PassUsuario=" + passUsuario + "]\n";
	}
	
}
