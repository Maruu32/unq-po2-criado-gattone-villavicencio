package ar.edu.unq.po2.tpfinal.zonadecobertura;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpfinal.AplicacionWeb;
import ar.edu.unq.po2.tpfinal.Muestra;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;

public class ZonaDeCobertura {
	
	/**
	 * @author Lenardo Criado
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
	private AplicacionWeb appWeb; 
	private List<ObserverZona> observers; 
	
	
	//getters
	public String getNombreZona() {
		return nombreZona;
	}
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	public double getRadio() {
		return radio;
	}
	protected List<ObserverZona> getObservers() {
		return observers;
	}
	private void setObservers(ArrayList<ObserverZona> arrayList) {
		this.observers = arrayList;
	}
	
	
	//setters
	protected void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}
	protected void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}
	protected void setRadio(double radio) {
		this.radio = radio;
	}
	protected void setAppWeb(AplicacionWeb appWeb) {
		this.appWeb = appWeb;
	}



	public ZonaDeCobertura(String string, Ubicacion epicentro, double d, AplicacionWeb app) { 
		this.setNombreZona(string);
		this.setEpicentro(epicentro); 
		this.setRadio(d);
		this.setAppWeb(app);
		this.setObservers(new ArrayList<ObserverZona>());
	}

	

	public List<Muestra> muestrasDentroDeZona() {
		/**
		 * Devuelve una lista de las muestras que estan dentro de la zona de cobertura tomando como origen la lista de muestras
		 */
		List<Muestra> muestras = appWeb.getMuestras(); 								// Tomo todas las muestras registradas
		return muestras
				.stream()
				.filter(muestra -> muestraEstaDentroDeZona(muestra))
				//Me quedo con las que tienen una distancia al epicentro menor o igual al radio de la zona
				.collect(Collectors.toList());
	}
	
	
	public boolean muestraEstaDentroDeZona(Muestra muestra) {
		/**
		 * Indica si una muestra está dentro de esta zona de cobertura
		 */
		return this.distanciaEnKmAEpicentro(muestra.getUbicacion()) <= this.getRadio();
	}
	
	

	public List<ZonaDeCobertura> zonasSolapadas() {
		/**
		 * Devuelve una lista de las zonas que se solapan
		 */
		List<ZonaDeCobertura> zonas = appWeb.getZonasDeCobertura() 
												.stream()
												.filter(zona -> zona != this)		// Tomo todas las zonas exepto esta.
												.collect(Collectors.toList());
		return zonas
				.stream()
				.filter(zona -> this.distanciaEnKmAEpicentro(zona.getEpicentro()) 	// La distancia entre los epicentros
						< 															// tiene que ser menor	
						(this.radio + zona.getRadio()))								// a la suma de los radios de esta zona y la que se está evaluando
				.collect(Collectors.toList());
	}
	
	
	private double distanciaEnKmAEpicentro(Ubicacion ubicacion) {
		Ubicacion epicentro = this.getEpicentro();
		return epicentro.distanciaEnKm(ubicacion);
	}

	public void notificar(Muestra muestra, TipoAvisoZona tipoAviso) {
		/**
		 * Notifica a los observers si la muestra está dentro de la zona de cobertura
		 */
		if (this.muestraEstaDentroDeZona(muestra)) 
			this.getObservers().forEach(observer -> observer.update(this, muestra, tipoAviso));
	}

	public void addObserver(ObserverZona orga1) {
		this.getObservers().add(orga1);
		
	}
	

}
