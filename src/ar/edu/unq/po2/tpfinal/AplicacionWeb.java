package ar.edu.unq.po2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class AplicacionWeb {
	List<Muestra> muestras;
	List<ZonaDeCobertura> zonasDeCobertura;
	List<Organizacion> organizaciones;
	List<Usuario> usuarios;
	List<Opinion> opiniones;

	
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
	public List<Usuario> getUsuarios() {

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

	protected void setUsuarios(List<Usuario> usuarios) {

		this.usuarios = usuarios;
	}
	
	
	public AplicacionWeb() {
		super();
		this.setMuestras(new ArrayList<Muestra>());
		this.setOrganizaciones(new ArrayList<Organizacion>());
		this.setUsuarios(new ArrayList<Usuario>());
		this.setZonasDeCobertura(new ArrayList<ZonaDeCobertura>());
	}
	
	public void addMuestra(Muestra muestra) {
		/**
		 * Agrega muestra y avisa a las zonas de cobertura que se cargó una nueva muestra
		 */
		this.getMuestras().add(muestra);
		this.avisoMuestraZonas(muestra, TipoAvisoZona.NUEVA_MUESTRA);
	}

	

	public void avisoMuestraZonas(Muestra muestra, TipoAvisoZona tipoAviso) {
		/**
		 * Dispara la notificacion de aviso a las zonas 
		 */
		this.getZonasDeCobertura()
				.forEach(zona -> zona.notificar(muestra, tipoAviso));
	}
	
	public void addUsuario(Usuario persona) {
		this.getUsuarios().add(persona);
	}
	
	public void addZonaDeCobertura(ZonaDeCobertura zona) {
		this.getZonasDeCobertura().add(zona);
	}
	
	public void addOrganizacion(Organizacion organizacion1) {
		this.getOrganizaciones().add(organizacion1);
	}
	public void agregarOpinion(Opinion opinion) {
		opiniones.add(opinion); 
		
	}
	
	public List<Opinion> getOpiniones(){
		return opiniones; 
	}

	
	public void registarUsuario(String _nombre,EstadoUsuario estado) {
		addUsuario(new Usuario(_nombre, estado)); 
		
	}
	 	
}
