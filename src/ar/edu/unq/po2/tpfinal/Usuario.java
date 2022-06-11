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

	public void opinar() {
		estadoUsuario.opinar(this);
	}

	public void setEstadoUsuario(UExperto uExperto) {
		// TODO Auto-generated method stub 
		
	}

	public ArrayList<Muestra> getMisMuestras() {
		return misMuestras;
	}

	public ArrayList<Opinion> getMisOpiniones() {
		return misOpiniones;
	}
	
	public long contarDias(LocalDate inicio, LocalDate fin) {
		 long dias = ChronoUnit.DAYS.between(inicio,fin);
		 return dias;
	}
	


	
	

}
