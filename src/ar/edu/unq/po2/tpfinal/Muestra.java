package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Muestra {
	
	private Usuario usuarioCreador;
	private LocalDate fecha;
	private ClasificacionMuestra clasificacionMuestra;
	ArrayList<Opinion> opiniones;
	private Ubicacion ubicacion;

	public Muestra(Usuario u,ClasificacionMuestra cmuestra,Ubicacion ublicacion){
		usuarioCreador = u;
		fecha = LocalDate.now();
		clasificacionMuestra = cmuestra;
		opiniones.add(new Opinion(usuarioCreador,this, u.getEstadoUsuario(), cmuestra)); 
		
		
	 
	}

	public LocalDate getFecha() {
		return fecha;
	}




}
