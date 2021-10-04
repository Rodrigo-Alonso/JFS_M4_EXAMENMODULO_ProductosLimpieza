package cl.edutecno.servlets;

import java.awt.Point;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.facade.Facade;


@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		Facade facade = new Facade();
		ProductoDTO dto = new ProductoDTO();
		
		try {
			
			dto = facade.obtenerProductoById(idProducto);
			request.setAttribute("producto", dto);
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
