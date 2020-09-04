package com.pildorita;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
 *
 * Servlet implementation class ControladorArticulos
 *debe listar la informacion almacenada en la base de datos y de insetar la informacion de del formulario
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
		
		
		//si no se envia el parametro ,listar articulos
		
		if (elComando==null) {
			elComando="listar";
			
		}
		
		//redirigir el flujo de ejecucuion al metodo adecuado
		
		switch (elComando) {
		case "listar":
			
			obtenerArticulos(request,response);
			break;
		case "insertarBBDD":
			insertarArticulos(request,response);
			
			break;
		case "cargar":
			try {
				cargaArticulos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		case "actualizarBBDD":
			try {
				actualizaArticulos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break ;
			
		case "eliminar":
			try {
				eliminarAr(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			obtenerArticulos(request,response);
			
			
		}
		
		
		
		
	}
//si lansa una excepscion en la llamada ,rodeaer  con try cah pracontrolar ese eexcepcion si ecurre erro no ayuda edintficar el error

	private void eliminarAr(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// TODO Auto-generated method stub
//		capturar el codigo artoculo(id)
		
		String Codcodigo=request.getParameter("carticulo");
		
//		borrar articulo ede la bbdd
		
		modeloarticulo.eliminararticulo(Codcodigo);
		
		
		
//		volver al listado de articulos
		obtenerArticulos(request,response);
	}


	private void actualizaArticulos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		
		//leer los datos que le viene del formulario de actualizar 

		String Codcodigo=request.getParameter("codigo");
		String Codnombre=request.getParameter("nombre");
		int Codid= Integer.parseInt( request.getParameter("id"));
		
		
		
		String Coddescripcion=request.getParameter("descripcion");
		Double Codexistencia=Double.parseDouble(request.getParameter("existencia"));
		Double Codprecio=Double.parseDouble( request.getParameter("precio"));
		
//		crear un objteo de tipo producto con lainfo de lformulario
		Articulos articuloActualizado=new Articulos( Codid, Codnombre, Coddescripcion, Codcodigo, Codexistencia,Codprecio);

		
		
		
		
//		actualizar la base de datos con la info del objeto producto
		
		modeloarticulo.ActualizarProducto(articuloActualizado); 

		
		//volver al listado con la info actualizada
		obtenerArticulos(request,response);
		
	}


	private void cargaArticulos(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// TODO Auto-generated method stub
		//leer el codigo articulo que viene del listado de articulos
		//comunicar con el modelo para que este haga una conuslta a la bbdd cuyo criterio sera el codigo aarticulo que le enviamos
		//leer
		String codigoArticulo=request.getParameter("carticulo");
		
		
//enviar carticulo al modelo	
//		en definitiva obtenemos aqi el ariculo  que el usuario desea actualisar
		Articulos elArticulo=modeloarticulo.getArticulo(codigoArticulo);
		
		//colocar atributo correspondiente al codigo articulo  
		request.setAttribute("articulo_actualizado", elArticulo);
		
		//enviar todo la informacion del articulo al formulario de actualisar(jsp)
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarArticulo.jsp");
		
		dispatcher.forward(request, response);
		
		
		
	}


	private void insertarArticulos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//leer la informacion del articulo que eviene del formulario
		
		String Codcodigo=request.getParameter("codigo");
		String Codnombre=request.getParameter("nombre");
		int Codid= Integer.parseInt( request.getParameter("id"));
		
		//
		
		
		//SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
			//Date Fecha=null;
		/*	
			try {
				
				Fecha =(Date) formatoFecha.parse(request.getParameter("fecha"));
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		
		*/
		
		String Coddescripcion=request.getParameter("descripcion");
		Double Codexistencia=Double.parseDouble(request.getParameter("existencia"));
		Double Codprecio=Double.parseDouble( request.getParameter("precio"));
		
		//crear un objeto de tipo producto
		
		Articulos nuevoarticulo=new Articulos( Codid, Codnombre, Coddescripcion, Codcodigo, Codexistencia,Codprecio);
		
		//enviar el objeto al modelo y despues insertar el objeto Articulo en la base de datos
		try {
			modeloarticulo.AgregarelnuevoArticulo(nuevoarticulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//volver al listado de productos(en mi caso articulo)
		obtenerArticulos(request,response);//mostrar la vista para ver la insercion
		
	}


	private void obtenerArticulos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
//		obtener la lista de articulos del articulo(modelo)
		List<Articulos>articulos;
try {
			
			
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
