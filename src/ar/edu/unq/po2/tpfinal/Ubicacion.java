package ar.edu.unq.po2.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class Ubicacion {
	protected double latitud;
	protected double longitud;
	protected ICalculadorDistancia calculadoraDistancia;
	
	
	/**
	 * @author Leonardo Criado
	 * 
	 * Esta clase se encarga de gestionar las ubicacions a partir de una longitud y una latitud en double.
	 * 
	 * 
	 */
	
	public Ubicacion(double latitud, double longitud) {
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setCalculadoraDistancia(new DistanciaHaversine());
	}
	
	protected ICalculadorDistancia getCalculadoraDistancia() {
		return calculadoraDistancia;
	}

	protected void setCalculadoraDistancia(ICalculadorDistancia calculadoraDistancia) {
		this.calculadoraDistancia = calculadoraDistancia;
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

	public double distanciaEnKm(Ubicacion ubicacion1) {
		/**
		 * Indica la distancia en kilometros entre esta ubiciacion y @param ubicacion1
		 *
		 */
		return calculadoraDistancia.distanciaEnKm(	this.getLongitud(), 
													this.getLatitud(), 
													ubicacion1.getLongitud(), 
													ubicacion1.getLatitud());
	}

	public List<Ubicacion> ubicacionesAMenosDe(double distancia, List<Ubicacion> ubicaciones) {
		/**
		 * Retorna una sublista de @param ubicaciones con las ubicaciones a menos de @param distancia en km
		 */
		return ubicaciones		
				.stream()								
				.filter(ubi -> this.distanciaEnKm(ubi) < distancia) //Filtrando ubicaciones menores a distancia
				.collect(Collectors.toList());
	}
	
	
	
}