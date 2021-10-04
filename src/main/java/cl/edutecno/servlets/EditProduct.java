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

@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		Facade facade = new Facade();
		ProductoDTO dto = new ProductoDTO();
		List<CategoriaDTO> listaCategorias = null;

		try {

			dto = facade.obtenerProductoById(idProducto);
			listaCategorias = facade.listarCategorias();
			HttpSession session = request.getSession(true);
			String user = (String) session.getValue("user");

			request.setAttribute("user", user);
			request.setAttribute("producto", dto);
			request.setAttribute("listaCategorias", listaCategorias);
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String[] idProduct = request.getParameterMap().get("idProduct");
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));
		String nameProduct = request.getParameter("name");
		int priceProduct = Integer.parseInt(request.getParameter("price"));
		String descriptionProduct = request.getParameter("description");
		int idCategory = Integer.parseInt(request.getParameter("category"));
		
		Facade facade = new Facade();
		
		try {
			
			HttpSession session = request.getSession(true);
			int idUser = (Integer) session.getValue("id");
			
			ProductoDTO dto = new ProductoDTO();
			dto.setIdProducto(idProduct);
			dto.setNombreProducto(nameProduct);
			dto.setDescripcionProducto(descriptionProduct);
			dto.setPrecioProducto(priceProduct);
			dto.setIdCategoria(idCategory);
			dto.setIdUsuario(idUser);
			
//			for (String idTemp : idProduct) {
//				dto.setIdProducto(Integer.parseInt(idTemp));
//			}
			
			int status = facade.actualizarProducto(dto);
			request.getRequestDispatcher("/listarProductos").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
