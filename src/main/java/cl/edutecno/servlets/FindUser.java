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

@WebServlet("/findUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		
		Facade facade = new Facade();
		try {
			
			UsuarioDTO dto = new UsuarioDTO();
			dto = facade.obtenerUsuarioByEmail(email);

			if (dto != null && email.contentEquals(dto.getCorreoUsuario())) {
				
				request.setAttribute("name", dto.getNombreUsuario());
				request.setAttribute("email", dto.getCorreoUsuario());
				request.getRequestDispatcher("EditPassword.jsp").forward(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario no encontrado!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
