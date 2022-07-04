package ar.edu.unq.po2.tpfinal.persona;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ar.edu.unq.po2.tpfinal.AplicacionWeb;
import ar.edu.unq.po2.tpfinal.muestra.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.muestra.Opinion;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;



public class Usuario {
	private String nombre;
	private EstadoUsuario estadoUsuario; 
	private ArrayList<Muestra> susMuestras;
	private ArrayList<Opinion> susOpiniones;
	private AplicacionWeb appWeb;

	
	
	public Usuario(String _nombre,EstadoUsuario estado, AplicacionWeb _appWeb){
		nombre = _nombre;
		estadoUsuario = estado;
		susMuestras = new ArrayList<Muestra>(); 
		susOpiniones = new ArrayList<Opinion>();
		appWeb = _appWeb;
	}
	
	public void nuevaMuestra(ClasificacionMuestra cmuestra, Ubicacion ubicacion ,BufferedImage foto, Opinion aOpinion ) {
		appWeb.addMuestra(new Muestra(this, ubicacion, foto, aOpinion ));
	}

	public void opinar(ClasificacionMuestra clasificacion, Muestra muestra) {
		estadoUsuario.opinar(clasificacion, this, muestra);
		
	}
	
	public void setEstadoUsuario(EstadoUsuario _estadoUsuario) { 
		estadoUsuario = _estadoUsuario;
	}

	public ArrayList<Opinion> getSusOpiniones() {
		return susOpiniones;
	}

	public EstadoUsuario getEstadoUsuario() {
		// TODO Auto-generated method stub
		return estadoUsuario;
	}

	
	public void agregarOpinion(Opinion opinion) {
		susOpiniones.add(opinion);
	}

	public AplicacionWeb getAppWeb() {
		// TODO Auto-generated method stub
		return appWeb;
	}

}

	
	


