package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class RegistrarProductosController
 */
@WebServlet("/RegistrarProductosController")
public class RegistrarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private CategoriaDAO categoriaDao;
	
	private Producto producto;
	private Categoria categoria;
	
	private int empresa_id;
	private int usuario_id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProductosController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
        categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
        
        producto = new Producto();
        categoria = new Categoria();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			categoria = categoriaDao.read(Integer.valueOf(request.getParameter("categoria")));
			empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
			usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			
			producto.setId(0);
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			producto.setEstado("h");
			producto.setCategoria(categoria);
			productoDao.crear(producto,empresa_id,categoria.getId());	
			
			url = "/JSPs/registrar_producto.jsp";
			
		} catch (Exception e) {
			System.out.print("Error Registrar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
