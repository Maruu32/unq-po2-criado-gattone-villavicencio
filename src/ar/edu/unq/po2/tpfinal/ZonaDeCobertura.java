package ar.edu.unq.po2.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class ZonaDeCobertura {
	
	/**
	 * @author LeO
	 * 
	 * @since 01/06/2022
	 * 
	 * Esta clase modela una zona de cobertura la cual esta compuesta por
	 * Un nombre String
	 * Un epicentro modelado como Ubicacion
	 * Un radio double
	 * * 
	 * Y colabora con una appWeb que debe conocer un conjunto de muestras y otras zonas de cobertura.
	 * 
	 */
	
	private String nombreZona;
	private Ubicacion epicentro;
	private double radio;
	private AplicacionWeb appWeb;  // usar interface?

	public ZonaDeCobertura(String string, Ubicacion ubicacion1, double d, AplicacionWeb app) {
		this.nombreZona = string;
		this.epicentro = ubicacion1;
		this.radio = d;
		this.appWeb = app;
	}

	protected String getNombreZona() {
		return nombreZona;
	}

	protected Ubicacion getEpicentro() {
		return epicentro;
	}

	protected double getRadio() {
		return radio;
	}

	public List<Muestra> muestrasDentroDeZona() {
		/**
		 * Devuelve una lista de las muestrs que estan dentro de la zona de cobertura
		 */
		List<Muestra> muestras = appWeb.getMuestras(); // Tomo todas las muestras registradas
		return muestras
				.stream()
				.filter(muestra -> this.getEpicentro().distanciaEnKm(muestra.getUbicacion()) <= this.getRadio())
				//Me quedo con las que tienen una distancia al epicentro menor o igual al radio de la zona
				.collect(Collectors.toList());
	}

	public List<ZonaDeCobertura> zonasSolapadas() {
		/**
		 * Devuelve una lista de las zonas que se solapan
		 */
		List<ZonaDeCobertura> zonas = appWeb.getZonasDeCobertura() // Tomo todas las zonas exepto esta.
												.stream()
												.filter(zona -> zona != this)
												.collect(Collectors.toList());
		return zonas
				.stream()
				.filter(zona -> this.getEpicentro().distanciaEnKm(zona.getEpicentro()) 	// La distancia entre los epicentros
						< 																// tiene que ser menor	
						(this.radio + zona.getRadio()))										// a la suma de los radios de esta zona y la que se está evaluando
				.collect(Collectors.toList());
	}

}
