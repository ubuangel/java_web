package com.pildorita;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//definir el datasource
	@Resource(name="jdbc/articulos")
	
	//crear varaible  datasource = pullconextion
	private DataSource mipool;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//crea rel objeto printwriter
		PrintWriter salida=response.getWriter();
		
		response.setContentType("text/plain");
		
		//crear conexion con bd
		Connection miconexion=null;
		Statement mistatement=null;
		ResultSet miresultset=null;
		
		try {
			
			miconexion=mipool.getConnection();
			String mysql="SELECT  *FROM articulos";
			mistatement=miconexion.createStatement();
			miresultset=mistatement.executeQuery(mysql);
			
			while (miresultset.next()) {
				String nombredearticulo=miresultset.getString(3);
				salida.println(nombredearticulo);
				
			}	
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
