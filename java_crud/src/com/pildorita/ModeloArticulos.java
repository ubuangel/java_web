package com.pildorita;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class ModeloArticulos {
	
	private DataSource origendatos;
	public ModeloArticulos(DataSource origendatos) {
		this.origendatos=origendatos;
//		el onstructor almacenar dentro de  origen datos el poll
		
	}
	
	public List<Articulos> getArti() throws Exception{
		
		List<Articulos>articulos=new ArrayList<>();
		
		Connection miconexion=null;
		Statement mistatement=null;
		ResultSet miresulset=null;
		
		//establecer la conexion----------------------
		miconexion=origendatos.getConnection();//irgendatos tengo el pool de datos
		//crear la sentecia sql y statement
		String mysql="select *from articulos";
		mistatement=miconexion.createStatement();
		
		//ejecutar la seentencia sql
		miresulset=mistatement.executeQuery(mysql);
		
//		recorrer el resultset obtenido
		
while (miresulset.next()) {
	
	String c_art=miresulset.getString("codigo");
	String nnombre=miresulset.getString("nombre");
	String ndes=miresulset.getString("descripcion");
	
	int nid=miresulset.getInt("id");
	double nex=miresulset.getDouble("existencia");
	double pre=miresulset.getDouble("precio");
	
	Articulos temparticulo=new Articulos(nid,nnombre, ndes, c_art, nex, pre);
	articulos.add(temparticulo);
	
}		
return articulos; 		
	}

}
