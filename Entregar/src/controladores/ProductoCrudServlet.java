package controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProductosTipos.Producto;

import com.ipartek.ejemplos.joseba.dal.DalFactory;
import com.ipartek.ejemplos.joseba.dal.ProductoDAL;

@WebServlet("/productocrud")
public class ProductoCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String RUTA_LISTADO = "/WEB-INF/vistas/productocrud.jsp";
	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/productoform.jsp";
	static final String RUTA_SERVLET_LISTADO = "/productocrud";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = request.getServletContext();
		ProductoDAL dal = (ProductoDAL) application.getAttribute("dal");// Si entras por
																		// primera vez se
																		// crea un objeto
																		// dal lo guarda y
																		// siempre coge el
																		// mismo si entras
																		// de nuevo
		if (dal == null) {
			dal = DalFactory.getProductoDAL();

			dal.alta(new Producto(1, "Manzana", "Manzana de Asturias", 1.2));
			dal.alta(new Producto(2, "Tomate", "Tomates de Jaen", 2.2));
			application.setAttribute("dal", dal);
		}

		String op = request.getParameter("op");

		if (op == null) {

			Producto[] productos = dal.buscarTodosLosProductos();

			request.setAttribute("productos", productos);

			request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
		} else {

			Producto producto;

			switch (op) {
			case "modificar":
			case "borrar":
				Integer id = Integer.parseInt(request.getParameter("id"));

				producto = dal.buscarPorId(id);

				request.setAttribute("producto", producto);
			case "alta":
				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
			}
		}
	}
}
