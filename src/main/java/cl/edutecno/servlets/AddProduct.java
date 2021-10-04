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
import cl.edutecno.dto.ProductoDTO;
import cl.edutecno.facade.Facade;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
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
			String user = (String) session.getValue("user");

			request.setAttribute("user", user);
			request.setAttribute("listaCategorias", listaCategorias);
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		int idCategory = Integer.parseInt(request.getParameter("category"));

		Facade facade = new Facade();

		try {

			HttpSession session = request.getSession(true);
			int idUsuario = (Integer) session.getValue("id");

			ProductoDTO dto = new ProductoDTO();
			dto.setNombreProducto(name);
			dto.setPrecioProducto(price);
			dto.setDescripcionProducto(description);
			dto.setIdCategoria(idCategory);
			dto.setIdUsuario(idUsuario);

			int status = facade.registrarProducto(dto);
			request.getRequestDispatcher("/listarProductos").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
