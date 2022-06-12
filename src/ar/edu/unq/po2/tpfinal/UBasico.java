package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class UBasico implements EstadoUsuario  {
	
	private Muestra muestra;
	private Usuario usuario;
	
	public UBasico(Usuario _usuario) { 
		usuario = _usuario;
		
	}
	

	@Override
	public void opinar(ClasificacionMuestra clasificacion) {
		//crea una opinion si puede opinar en la Muestra
		if (puedeOpiniar()) {
			 AplicacionWeb.agregarOpinion(new Opinion(usuario, muestra, this, clasificacion));
			 subirCategoria(usuario);	
		}
		
	}
	
	private void subirCategoria(Usuario usuario) {
		//Si cumple con la cantidad de muestras y opiniones sube de categoria
		if(relizoDiezMuestras() && realizoVeinteOpiniones()){
			usuario.setEstadoUsuario(new UExperto(usuario));
		}
	}


	private boolean realizoVeinteOpiniones(){
		ArrayList<Opinion> resultado = new ArrayList<>();
		usuario.getMisOpiniones().parallelStream().filter(p->contarDias(p.getFecha(),LocalDate.now())>30).forEach(p -> resultado.add(p));
		return resultado.size() > 20;
	}


	private boolean relizoDiezMuestras() {
		ArrayList<Muestra> resultado = new ArrayList<>();
		usuario.getMisMuestras().parallelStream().filter(p->contarDias(p.getFecha(),LocalDate.now())>30 ).forEach(p -> resultado.add(p));
		return resultado.size() > 10;
	}


	public boolean puedeOpiniar(){
		//devuelve true si otodos alcanaza la cantidad que pide de muestras y de opiniones
		return relizoDiezMuestras() && realizoVeinteOpiniones() ;
	}
	
	public long contarDias(LocalDate inicio, LocalDate fin) {
		//me devuelve los que se llevan el incio y el fin
		 long dias = ChronoUnit.DAYS.between(inicio,fin);
		 return dias;
	}


}
