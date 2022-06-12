package ar.edu.unq.po2.tpfinal;

import java.util.List;
import java.util.ArrayList;


public class AplicacionWeb { 
	
	private ArrayList<Usuario> usuarios;
	private static List<Muestra> muestras;
	private static ArrayList<Opinion> opiniones;

	public List<Muestra> getMuestras() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void agregarOpinion(Opinion opinion) {
		opiniones.add(opinion);
		
	}

	public static void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
		
	}
	
	
	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	
	public void registrarUsuario(String nombre, EstadoUsuario estado) {
		Usuario usuario = new Usuario(nombre, estado);
		usuarios.add(usuario);
		
	}
	




}
