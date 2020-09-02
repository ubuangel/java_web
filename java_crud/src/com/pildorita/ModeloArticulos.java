package com.pildorita;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public void AgregarelnuevoArticulo(String nuevoarticulo) {
		// TODO Auto-generated method stub
		//obtener la conexion
		
		Connection miconexion=null;
		PreparedStatement mistatement=null;
		
		try {
			
			
			//crearinstruccion sql que inserte e larticulo
			miconexion=origendatos.getConnection();
			
			String sql="insert into articulos (id,codigo,nombre,descripcioin ,existencia ,precio)"+"VALUES(?,?,?,?,?,?)";
			mistatement=miconexion.prepareStatement(sql);
			//establecer los parametros para elarticulo

			mistatement.setString(1, nuevoarticulo.);r
			mistatement.setInt(1,nuevoarticulo.getnid());
			mistatement.setString(2,nuevoarticulo.getncodigo());
			mistatement.setString(3,nuevoarticulo.getnombre());
			mistatement.setString(4,nuevoarticulo.getdescripcion());
			mistatement.setDouble(5,nuevoarticulo.getnexistencia());
			mistatement.setDouble(6,nuevoarticulo.getnprecio());
			
			//ejecutar la instruccion sql
			
			mistatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
