package ar.edu.unq.po2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class AplicacionWeb {
	List<Muestra> muestras;
	List<ZonaDeCobertura> zonasDeCobertura;
	List<Organizacion> organizaciones;
	List<Persona> usuarios;
	
	/**
	 * @author Leonardo Criado
	 * 
	 * La responsabilidad de esta clase es ser el main del programa y consolidar las clases que la componen
	 *  
	 * @return
	 */
	
	
	//getters
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}
	public List<Organizacion> getOrganizaciones() {
		return organizaciones;
	}
	public List<Persona> getUsuarios() {
		return usuarios;
	}
	
	
	//setters
	protected void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
	protected void setZonasDeCobertura(List<ZonaDeCobertura> zonasDeCobertura) {
		this.zonasDeCobertura = zonasDeCobertura;
	}
	protected void setOrganizaciones(List<Organizacion> organizaciones) {
		this.organizaciones = organizaciones;
	}
	protected void setUsuarios(List<Persona> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public AplicacionWeb() {
		super();
		this.setMuestras(new ArrayList<Muestra>());
		this.setOrganizaciones(new ArrayList<Organizacion>());
		this.setUsuarios(new ArrayList<Persona>());
		this.setZonasDeCobertura(new ArrayList<ZonaDeCobertura>());
	}
	
	public void addMuestra(Muestra muestra) {
		/**
		 * Agrega muestra y avisa a las zonas de cobertura
		 */
		this.getMuestras().add(muestra);
		this.avisoNuevaMuestraZonas(muestra);
	}
	

	private void avisoNuevaMuestraZonas(Muestra muestra) {
		/**
		 * Dispara la notificacion de nueva muestra 
		 */
		this.getZonasDeCobertura()
				.forEach(zona -> zona.notificar(muestra, "Nueva muestra"));
	}
	
	public void addUsuario(Persona persona) {
		this.getUsuarios().add(persona);
	}
	
	public void addZonaDeCobertura(ZonaDeCobertura zona) {
		this.getZonasDeCobertura().add(zona);
	}
	
	public void addOrganizacion(Organizacion organizacion1) {
		this.getOrganizaciones().add(organizacion1);
	}	
	
	

}
