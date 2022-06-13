package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class UBasico implements EstadoUsuario  { 
	
	private Muestra muestra;
	private Usuario usuario;
	
	public UBasico(Usuario _usuario, Muestra _muestra) { 
		usuario = _usuario;
		muestra= _muestra;
		
	}
	

	@Override
	public void opinar(ClasificacionMuestra clasificacion, Usuario u, Muestra muestra) {
		//crea una opinion si puede opinar en la Muestra
		if (puedeOpinar()) {
			 usuario.getAp().agregarOpinion(new Opinion(usuario, muestra, clasificacion)); 
			 subirCategoria(usuario);	
		}
		
	}
	
	private void subirCategoria(Usuario usuario) {
		//Si cumple con la cantidad de muestras y opiniones sube de categoria
		if(relizoDiezMuestras() && realizoVeinteOpiniones()){
			usuario.setEstadoUsuario(new UExperto(usuario,muestra));
		}
	}


	boolean realizoVeinteOpiniones(){
		ArrayList<Opinion> resultado = new ArrayList<>();
		usuario.getMisOpiniones().parallelStream().filter(p->contarDias(p.getFechaCreacion(),LocalDate.now())>30).forEach(p -> resultado.add(p));
		return resultado.size() > 20;
	}


	boolean relizoDiezMuestras() {
		ArrayList<Muestra> resultado = new ArrayList<>();
		usuario.getMisMuestras().parallelStream().filter(p->contarDias(p.getFechaCreacion(),LocalDate.now())>30 ).forEach(p -> resultado.add(p));
		return resultado.size() > 10;  
	}
	
	
	public boolean puedeOpinar() {
		//devuelve true la lista de opinones de experto esta vacia
		return muestra.getOpinionesExpertos().isEmpty();
	}
	
	public long contarDias(LocalDate inicio, LocalDate fin) {
		//me devuelve los que se llevan el incio y el fin
		 long dias = ChronoUnit.DAYS.between(inicio,fin);
		 return dias; 
	}






}
