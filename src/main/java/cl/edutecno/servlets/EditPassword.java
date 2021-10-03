package cl.edutecno.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dto.UsuarioDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/editPassword")
public class EditPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String[] email = request.getParameterMap().get("email");
		String password = request.getParameter("password");
		
		UsuarioDTO dto = new UsuarioDTO();
		
		for (String emailTemp : email) {
			dto.setCorreoUsuario(emailTemp);
			break;
		}
		
		dto.setPassUsuario(password);
		
		Facade facade = new Facade();
		try {
			int status = facade.cambiarPassUsuario(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		

	}

}
