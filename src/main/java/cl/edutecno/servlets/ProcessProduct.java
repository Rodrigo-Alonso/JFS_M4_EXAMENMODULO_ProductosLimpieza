package cl.edutecno.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.edutecno.dto.CategoriaDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/processProduct")
public class ProcessProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Facade facade = new Facade();
		
		try {
			
			List<CategoriaDTO> listaCategorias = null;
			try {
				listaCategorias = facade.listarCategorias();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession(true);
			String user = (String)session.getValue("user");
			
			request.setAttribute("user", user);
			request.setAttribute("listaCategorias", listaCategorias);
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
