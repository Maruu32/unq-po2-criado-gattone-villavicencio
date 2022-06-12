package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.time.Month;

public class Usuario {
	private String nombre;
	private EstadoUsuario estadoUsuario;
	private ArrayList<Muestra> misMuestras;
	private ArrayList<Opinion> misOpiniones;
	
	
	public Usuario(String _nombre,EstadoUsuario estado){
		nombre = _nombre;
		estadoUsuario = estado;
		misMuestras = new ArrayList<Muestra>();
		misOpiniones = new ArrayList<Opinion>();
	}
	
	public void nuevaMuestra(ClasificacionMuestra cmuestra, Ubicacion ubicacion) {
		AplicacionWeb.agregarMuestra(new Muestra(this, cmuestra, ubicacion));
	}

	public void opinar(ClasificacionMuestra clasificacion) {
		estadoUsuario.opinar(clasificacion);
		
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



	
	

}
