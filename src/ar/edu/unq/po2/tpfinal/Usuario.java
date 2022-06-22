package ar.edu.unq.po2.tpfinal;


import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class Usuario {
	private String nombre;
	private EstadoUsuario estadoUsuario; 
	private ArrayList<Muestra> misMuestras;
	private ArrayList<Opinion> misOpiniones;
	private AplicacionWeb appWeb;
	
	
	public Usuario(String _nombre,EstadoUsuario estado){
		nombre = _nombre;
		estadoUsuario = estado;
		misMuestras = new ArrayList<Muestra>(); 
		misOpiniones = new ArrayList<Opinion>();
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

	public ArrayList<Muestra> getMisMuestras() {
		return misMuestras;
	}

	public ArrayList<Opinion> getMisOpiniones() {
		return misOpiniones;
	}

	public EstadoUsuario getEstadoUsuario() {
		// TODO Auto-generated method stub
		return estadoUsuario;
	}

	public AplicacionWeb getAp() {
		// TODO Auto-generated method stub
		return appWeb;
	}

}

	
	


