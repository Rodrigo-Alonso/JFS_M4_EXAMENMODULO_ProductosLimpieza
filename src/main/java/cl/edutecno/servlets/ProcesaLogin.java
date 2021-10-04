package cl.edutecno.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.edutecno.dto.UsuarioDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		Facade facade = new Facade();
		try {
			UsuarioDTO dto = new UsuarioDTO();
			dto = facade.obtenerUsuarioByEmail(email);

			if (dto != null && email.contentEquals(dto.getCorreoUsuario())
					&& pass.contentEquals(dto.getPassUsuario())) {
				HttpSession sesionUsuario = request.getSession(true);
				sesionUsuario.setAttribute("email", dto.getCorreoUsuario());
				sesionUsuario.setAttribute("id", dto.getIdUsuario());
				sesionUsuario.setAttribute("user", dto.getNombreUsuario());
				
				request.getRequestDispatcher("/listarProductos").forward(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario o password incorrecto!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
