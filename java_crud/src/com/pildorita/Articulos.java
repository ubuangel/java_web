package com.pildorita;

public class Articulos {
	
	
	public Articulos(int nid, String nnombre, String ndescripcion, String ncodigoString, double nexistencia,
			double nprecio) {
//		super();
		this.nid = nid;
		this.nnombre = nnombre;
		this.ndescripcion = ndescripcion;
		this.ncodigoString = ncodigoString;
		this.nexistencia = nexistencia;
		this.nprecio = nprecio;
	}
	
	
	public Articulos(String nnombre, String ndescripcion, String ncodigoString, double nexistencia, double nprecio) {
//		super();
		this.nnombre = nnombre;
		this.ndescripcion = ndescripcion;
		this.ncodigoString = ncodigoString;
		this.nexistencia = nexistencia;
		this.nprecio = nprecio;
	}


	
	
	public int getNid() {
		return nid;
	}


	public void setNid(int nid) {
		this.nid = nid;
	}


	public String getNnombre() {
		return nnombre;
	}


	public void setNnombre(String nnombre) {
		this.nnombre = nnombre;
	}


	public String getNdescripcion() {
		return ndescripcion;
	}


	public void setNdescripcion(String ndescripcion) {
		this.ndescripcion = ndescripcion;
	}


	public String getNcodigoString() {
		return ncodigoString;
	}


	public void setNcodigoString(String ncodigoString) {
		this.ncodigoString = ncodigoString;
	}


	public double getNexistencia() {
		return nexistencia;
	}


	public void setNexistencia(double nexistencia) {
		this.nexistencia = nexistencia;
	}


	public double getNprecio() {
		return nprecio;
	}


	public void setNprecio(double nprecio) {
		this.nprecio = nprecio;
	}

//metodo mut muy utilisado tostring
	
	


	private int nid;
	@Override
	public String toString() {
		return "Articulos [nid=" + nid + ", nnombre=" + nnombre + ", ndescripcion=" + ndescripcion + ", ncodigoString="
				+ ncodigoString + ", nexistencia=" + nexistencia + ", nprecio=" + nprecio + "]";
	}

	private String nnombre;
	private String ndescripcion;
	private String ncodigoString;
	private double nexistencia;
	private double nprecio;
	
	

}
