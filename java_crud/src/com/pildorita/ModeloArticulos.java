package com.pildorita;

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

	public void AgregarelnuevoArticulo(Articulos nuevoarticulo)throws Exception {
		// TODO Auto-generated method stub
		
		Connection miconexion=null;
		PreparedStatement mistatement=null;
		//obtener la conexion
		
		try {
			
			
			//crearinstruccion sql que inserte e larticulo
			miconexion=origendatos.getConnection();
			
			String sql="insert into articulos (id,codigo,nombre,descripcion ,existencia ,precio)"+
			"VALUES(?,?,?,?,?,?)";
			mistatement=miconexion.prepareStatement(sql);
			//establecer los parametros para elarticulo
//el primer parametro es a que ase referenci a(indice del  parametro) y el segundo es el valor
			mistatement.setInt(1, nuevoarticulo.getNid());
			mistatement.setString(2,nuevoarticulo.getNcodigoString());
			mistatement.setString(3,nuevoarticulo.getNnombre());
			mistatement.setString(4,nuevoarticulo.getNdescripcion());
			mistatement.setDouble(5,nuevoarticulo.getNexistencia());
			mistatement.setDouble(6,nuevoarticulo.getNprecio());
			
			//ejecutar la instruccion sql
			
			mistatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
				mistatement.close();
				miconexion.close();
				
			
			
		}
		
		
		
		
		
		
		
	}

	public Articulos getArticulo(String codigoArticulo) {
		// TODO Auto-generated method stub
		
		Articulos elArticulos=null;
		Connection miConnection=null;
		
		PreparedStatement miStatement=null;
		
		ResultSet miResultSet=null;
		
		String cArticulo=codigoArticulo;
		
		try {
			//establecer la conexion
			miConnection=origendatos.getConnection();
			
			
			
//			crear sql que busque el producto
			
			
			String sql="select *from articulos where id=?";
			
			//crear la consulta preparada
			miStatement=miConnection.prepareStatement(sql);
			
//			estaablecer los parametros
			miStatement.setString(1,cArticulo);
			
			//ejecutar la consulta
			miResultSet=miStatement.executeQuery();
			
			
			//obtener los datos de respusta 
			if (miResultSet.next()) {
				int ind=miResultSet.getInt("id");
				String c_art=miResultSet.getString("codigo");
				String nnombre=miResultSet.getString("nombre");
				String ndes=miResultSet.getString("descripcion");
				
				double nex=miResultSet.getDouble("existencia");
				double pre=miResultSet.getDouble("precio");
				//el id evidentemente no lo queremos
				elArticulos=new Articulos(ind,nnombre, ndes, c_art, nex, pre);
				
				
			}else {
				throw new Exception("no hemos encontrado el producto con codigo articulo= "+ cArticulo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elArticulos;
		
		
		

	}

	public void ActualizarProducto(Articulos articuloActualizado)throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConnection=null;
//		crear una consulta preparada
		PreparedStatement miStatement=null;
		
		try {
//		String AArticulo=articuloActualizado;
		
		
			//establecer la conexion
			miConnection=origendatos.getConnection();
			
			
			
//			crear sql que busque el producto
			
			
			String sql="update articulos set codigo=?,nombre=?,descripcion=?,existencia=?,precio=? where id=?";
			
			//crear la consulta preparada
			miStatement=miConnection.prepareStatement(sql);
			
//			obtener la seccion de articulo que le 
			miStatement.setString(1,articuloActualizado.getNcodigoString());
			miStatement.setString(3,articuloActualizado.getNnombre());
			miStatement.setString(2,articuloActualizado.getNdescripcion());
			miStatement.setDouble(4,articuloActualizado.getNexistencia());
			
			miStatement.setDouble(5,articuloActualizado.getNprecio());
			miStatement.setInt(6,articuloActualizado.getNid());
			
			
			//ejecutar la instruccion     sql
			miStatement.execute();
			
		}	
			finally {
				miStatement.close();
				miConnection.close();
				
			} 
			
				
		
		
		
	}

	public void eliminararticulo(String codcodigo) throws Exception{
		
		// TODO Auto-generated method stub
		Connection miConnection=null;
		PreparedStatement miStatement=null;
		try {
			
			//		establecer laconexion bbdd}

		miConnection=origendatos.getConnection();

		//crear la sql de eliminacion
		String sql="delete from articulos where id=?";
		
		
		
		//preparar la consulta
		miStatement=miConnection.prepareStatement(sql);

		
		
		//establecer los parametros de consulta
		miStatement.setString(1,codcodigo);

		
		
	
//		ejecutarla sentecncia sql
		
		miStatement.execute();
		
			
		} finally {
			miStatement.close();
			miConnection.close();
			
		} 
		

		
		
	}

}
