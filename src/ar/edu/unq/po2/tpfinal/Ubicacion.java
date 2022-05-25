package ar.edu.unq.po2.tpfinal;

public class Ubicacion {
	protected double latitud;
	protected double longitud;
	
	/*
	 * @author Leonardo Criado
	 * 
	 * Esta clase se encarga de gestionar las ubicacions a partir de una longitud y una latitud en double.
	 * Se utiliza el algoritmo Haversine para el cálculo de distancias. 
	 * 
	 */
	
	public Ubicacion(double latitud, double longitud) {
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}
	
	public double getLatitud() {
		return latitud;
	}
		
	public double getLongitud() {
		return longitud;
	}
		
	protected void setLatitud(double latitud) {
		this.latitud = latitud;
	}
		
	protected void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
	
	
	
	
}
