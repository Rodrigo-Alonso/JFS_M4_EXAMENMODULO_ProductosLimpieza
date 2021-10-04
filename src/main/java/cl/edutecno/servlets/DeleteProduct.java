package cl.edutecno.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.facade.Facade;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		
		Facade facade = new Facade();
		try {
			int status = facade.borrarProducto(idProducto);
			request.getRequestDispatcher("/listarProductos").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
