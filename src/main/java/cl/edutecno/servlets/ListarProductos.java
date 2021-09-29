package cl.edutecno.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dto.CategoriaDTO;
import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/listarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Facade facade = new Facade();

		try {
			// Obtiene datos
			List<ProductoDTO> listaProductos = null;
			try {
				listaProductos = facade.listarProductos();
			} catch (Exception e) {
				e.printStackTrace();
			}

			List<CategoriaDTO> listaCategorias = null;
			try {
				listaCategorias = facade.listarCategorias();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Envio de datos
			request.setAttribute("listaProductos", listaProductos);
			request.setAttribute("listaCategorias", listaCategorias);

			// Redirecciona a .jsp
			request.getRequestDispatcher("Home.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
