package com.pildorita;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class ControladorArticulos
 */
@WebServlet("/ControladorArticulos")
public class ControladorArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloArticulos modeloarticulo;
	
@Resource(name="jdbc/articulos")
	
	//crear varaible  datasource = pullconextion
	private DataSource mipool;


@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	
	try {
		
		modeloarticulo =new ModeloArticulos(mipool);
	} catch (Exception e) {
		// TODO: handle exception
		throw new ServletException();
	}
	//conecatr con el modelo
	
}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		//leer el parametro del formulario
		String elComando=request.getParameter("instruccion");
		
		if (elCommando==null) {
			elCommando="listar";
			
		}
		//si no se envia el parametro ,listar
		
		
		
		//redirigir el flujo de ejecucuion al metodo adecuado
		
		switch (elComando) {
		case listar:
			
			obtenerArticulos(request,response);
			break;
		case insertarBBDD:
			insertarArticulos(request,response);
			
			break;
		default:
			obtenerArticulos(request,response);
			
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}


	private void insertarArticulos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//leer la informacion de lproducto que eviene del formulario
		
		String Codcodigo=request.getParameter("codigo");
		String Codnombre=request.getParameter("nombre");
		String Codid=request.getParameter("id");
		String Coddescripcion=request.getParameter("descripcion");
		String Codexistencia=request.getParameter("existencia");
		String Codprecio=request.getParameter("precio");
		//crear un objeto de tipo producto
		
		
		
		//enviar el objeto al modelo
		
		
		
		//insertar el objeto producto en la base de datos
		
		
		
		
		//volver al listado de productos
		
	}


	private void obtenerArticulos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		List<Articulos>articulos;
try {
			
//		obtener la lista de articulos del articulo(modelo)
			
			articulos=modeloarticulo.getArti();
			
			
			
//		agregar esa lista al request

			request.setAttribute("listaarticulos", articulos);
			
			
			
			
			//enviar el request a la pagina jsp
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/lista_articulos.jsp");
			
			miDispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}


}
