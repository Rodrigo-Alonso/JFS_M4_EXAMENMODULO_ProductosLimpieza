package cl.edutecno.servlets;

import java.io.IOException;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dto.UsuarioDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNombreUsuario(name);
		dto.setCorreoUsuario(email);
		dto.setTelefonoUsuario(phone);
		dto.setPassUsuario(password);
		
		Facade facade = new Facade();
		try {
			int status = facade.registrarUsuario(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
